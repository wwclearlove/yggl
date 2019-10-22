package com.cdivtc.web.controller;

import com.cdivtc.model.Result;
import com.cdivtc.model.ResultCode;
import com.cdivtc.model.UUser;
import com.cdivtc.service.TeacherService;
import com.cdivtc.util.IdWorker;
import com.cdivtc.util.MD5Utils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    IdWorker idWorker;
    @Autowired
    TeacherService teacherService;
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Result addTeacher(UUser uUser){
        System.out.println(uUser);
        uUser.setuId(idWorker.nextId()+"");
        uUser.setuFlag(1);
        uUser.setuPassword(MD5Utils.code(uUser.getuPassword()));
        int i = teacherService.addTeacher(uUser);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/delete",method = RequestMethod.DELETE)
    public Result deleteTeacher(String uId){
        int i = teacherService.deleteTeacher(uId);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public Result updateTeacher(UUser uUser){
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
}
