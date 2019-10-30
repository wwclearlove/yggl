package com.cdivtc.web.controller;

import com.cdivtc.model.Result;
import com.cdivtc.model.UUser;
import com.cdivtc.service.TeacherService;
import com.cdivtc.util.CodeUtil;
import com.cdivtc.util.IdWorker;
import com.cdivtc.util.MD5Utils;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    IdWorker idWorker;

    @Autowired
    TeacherService teacherService;
    @RequestMapping(value ="/updatePassword",method = RequestMethod.PUT)
    public Result updatePassword(@RequestBody Map<String,Object> map, HttpServletRequest request){
        Result result=new Result();
        if(map!=null){
            String newPassword = (String) map.get("newPassword");
            String oldPassword = (String) map.get("oldPassword");
            String uId = (String) map.get("uId");
            UUser teacherByPassword = teacherService.findTeacherByPassword(MD5Utils.code(oldPassword), uId);
            if(teacherByPassword==null){
                result.setMessage("你输入的原密码错误");
                result.setSuccess(false);
                return result;
            }
            UUser uUser=new UUser();
            uUser.setuId(uId);
            uUser.setuPassword(MD5Utils.code(newPassword));
            int i = teacherService.updateTeacher(uUser);
            if(i==1){
                result.setSuccess(true);
                request.getSession().removeAttribute("user");
            }else {
                result.setMessage("修改失败");
                result.setSuccess(false);
            }
        }else {
            result.setMessage("传入的参数没空");
            result.setSuccess(false);
        }


     return result;
    }
    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public Result updateTeacher(@RequestBody Map<String,Object> map, HttpServletRequest request){
        Result result=new Result();
        String uUsername = (String) map.get("uUsername");
        String uPassword = (String) map.get("uPassword");
        String uVerifyCode = (String) map.get("uVerifyCode");
        int uFlag = (int) map.get("uFlag");
        System.out.println("用户名："+uUsername+"密码"+uPassword+"验证码:"+uVerifyCode+"标识符"+uFlag);

        if (! CodeUtil.checkVerifyCode(request,uVerifyCode)) {
            result.setMessage("验证码错误");
            result.setSuccess(false);
            return  result;
        }
        UUser teacherByUsername = teacherService.findTeacherByUsername(uUsername, uFlag);
        if (teacherByUsername==null){
            result.setMessage("用户名不存在");
            result.setSuccess(false);
            return  result;
        }
        if(!teacherByUsername.getuPassword().equals(MD5Utils.code(uPassword))){
            result.setMessage("用户名或者密码错误");
            result.setSuccess(false);
        }else {
            request.getSession().setAttribute("user",teacherByUsername);
            result.setData(teacherByUsername);
          result.setSuccess(true);
        }
        return  result;
    }
}
