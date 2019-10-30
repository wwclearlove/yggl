package com.cdivtc.web.controller;

import com.cdivtc.model.*;
import com.cdivtc.service.TeacherService;
import com.cdivtc.util.IdWorker;
import com.cdivtc.util.MD5Utils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    IdWorker idWorker;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value ="/updateImg",method = RequestMethod.POST)
    public Result updateImg(@RequestParam("uId") String uId , @RequestParam("file") MultipartFile file){
        Result result=new Result();
        if(!"".equals(uId)&& uId!=null){
            shanchu( uId);
        }else {
            result.setMessage("修改失败,你传入的信息为空");
            result.setSuccess(false);
        }
        String img_name="";
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();

            String serverpath= ResourceUtils.getURL("classpath:static").getPath().replace("%20"," ").replace('/', '\\')+File.separator + "images"+File.separator + fileName;
            String    destFileName=serverpath.substring(6);//从路径字符串中取出工程路径
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            String s = destFileName.replaceAll("\\\\", "/");
            img_name = s.substring(s.indexOf("/static"));
            System.out.println(" 新 "+img_name);
        } catch (Exception e) {
            result.setMessage("上传失败"+e.getMessage());
            result.setSuccess(false);
            return result;
        }
        UUser uUser=new UUser();
        uUser.setuId(uId);
        if(!img_name.equals("")){
            uUser.setuImg(img_name);
        }
        int i = teacherService.updateTeacher(uUser);
        if(i==1){
            result.setData(img_name);
            result.setSuccess(true);
            return result;
        }else {
            return  Result.FAIL();
        }
    }

    private void shanchu(String uId) {
                UUser teacherByuId = teacherService.findTeacherByuId(uId, 0);
        if(teacherByuId!=null) {
            String s = teacherByuId.getuImg();

            String s1 = s.replaceAll("/", "\\\\");
            System.out.println(s1);
            String img_name = s1.substring(14);
            System.out.println(img_name);
            String name= null;
            try {
                name = ResourceUtils.getURL("classpath:static").getPath().replace("%20"," ").replace('/', '\\')+ File.separator + "images";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String name1 = name.substring(6);
            System.out.println(name);
            System.out.println(name1);
            System.out.println(name1+img_name);
            File file=new File(name1+img_name);
            if (!file.exists()) {
                System.out.println("删除文件失败:"  + "不存在！");

            } else {
                if (file.isFile()){
                    file.delete();
                }
            }
        }

    }

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Result addTeacher(@RequestParam("uUsername") String uUsername ,@RequestParam("uPassword") String uPassword ,
                             @RequestParam("uName") String uName ,@RequestParam("uCourse") String uCourse ,
                             @RequestParam("file") MultipartFile file){
        Result result=new Result();
        String img_name="";
        UUser uUser=new UUser();
        uUser.setuUsername(uUsername);
        uUser.setuPassword(uPassword);
        uUser.setuName(uName);
        uUser.setuCourse(uCourse);
        uUser.setuFlag(1);

        UUser teacherByUsername = teacherService.findTeacherByUsername(uUser.getuUsername(), uUser.getuFlag());
        if(teacherByUsername==null){
            System.out.println(uUser);
            uUser.setuId(idWorker.nextId()+"");
            uUser.setuFlag(1);
            uUser.setuPassword(MD5Utils.code(uUser.getuPassword()));
            try {
                //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
                String fileName = System.currentTimeMillis() + file.getOriginalFilename();
                String serverpath= ResourceUtils.getURL("classpath:static").getPath().replace("%20"," ").replace('/', '\\')+File.separator + "images"+File.separator + fileName;
                String    destFileName=serverpath.substring(6);//从路径字符串中取出工程路径
                System.out.println();
                System.out.println("2"+destFileName);
                File destFile = new File(destFileName);
                destFile.getParentFile().mkdirs();
                file.transferTo(destFile);
                String s = destFileName.replaceAll("\\\\", "/");
                 img_name = s.substring(s.indexOf("/static"));


            } catch (Exception e) {
                result.setMessage("上传失败"+e.getMessage());
                result.setSuccess(false);
               return result;
            }
            System.out.println(img_name);
            if(!img_name.equals("")){
                uUser.setuImg(img_name);
            }
            int i = teacherService.addTeacher(uUser);
            if(i==1){
                result.setSuccess(true);
                return result;
            }else {
                result.setSuccess(false);
                return result;
            }
        }else {
            result.setSuccess(false);
            result.setMessage("改用户已存在，不能添加");
            return result;
        }


    }
    @RequestMapping(value ="/addimg",method = RequestMethod.POST)
    public String addTeacherimg(  @RequestParam("uImg") MultipartFile file){
        System.out.println(file);

       return "success";
    }

    @RequestMapping(value ="/delete",method = RequestMethod.DELETE)
    public Result deleteTeacher(@RequestBody Map<String,Object> map){
        String  uId= (String) map.get("uId");
        int i = teacherService.deleteTeacher(uId);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public Result updateTeacher(@RequestBody UUser uUser){
        int i = teacherService.updateTeacher(uUser);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }

    @RequestMapping(value ="/findAll",method = RequestMethod.GET)
    public Result findAllTeacher(){
        Result result=null;
        List<UUser> teacher = teacherService.findTeacher();
        if(teacher!=null){
             result=new Result(ResultCode.SUCCESS,teacher);
        }else {
             result=new Result(ResultCode.FAIL);
        }
        return result;

    }
    @RequestMapping(value ="/findByName",method = RequestMethod.GET)
    public Result findByName(String name){
        Result result=null;
        List<UUser> teacher = teacherService.findTeacherByName(name);
        if(teacher!=null){
            result=new Result(ResultCode.SUCCESS,teacher);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;

    }
    @RequestMapping(value ="/findByCourse",method = RequestMethod.GET)
    public Result findByCourse(){
        Result result=null;
        Map<String, List<UUser>> teacherByCourseList = teacherService.findTeacherByCourseList();
        if(teacherByCourseList!=null){
            result=new Result(ResultCode.SUCCESS,teacherByCourseList);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;

    }
}
