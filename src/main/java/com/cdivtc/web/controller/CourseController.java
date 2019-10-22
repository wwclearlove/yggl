package com.cdivtc.web.controller;

import com.cdivtc.model.*;
import com.cdivtc.service.cClassService;
import com.cdivtc.service.cCourseService;
import com.cdivtc.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/course")
public class CourseController {
    @Autowired
    IdWorker idWorker;
    @Autowired
    cCourseService cCourseService;
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Result addCourse(@RequestBody CCourse cCourse){
        cCourse.setcId(idWorker.nextId()+"");
        int i = cCourseService.addCourse(cCourse);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/delete",method = RequestMethod.DELETE)
    public Result deleteCourse(@RequestBody Map<String,Object> map){
        String  cId= (String) map.get("cId");
        int i = cCourseService.deleteCourse(cId);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/update",method = RequestMethod.PUT)
    public Result updateCtClass(@RequestBody CCourse cCourse){
        int i = cCourseService.updateCourse(cCourse);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/findAll",method = RequestMethod.GET)
    public Result findAllCtClass(){
        Result result=null;
        List<CCourse> allClass =cCourseService.findAllCourse();
        if(allClass!=null){
            result=new Result(ResultCode.SUCCESS,allClass);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;

    }
    @RequestMapping(value ="/findPage",method = RequestMethod.GET)
    public Result findPage(Integer page,Integer row){
        Result result=null;
        if(page==null){
            page=1;
        }
        if(row==null){
            row=5;
        }
        PageBean<CCourse> pageBean= cCourseService.findPageCourse(page, row);
        if(pageBean!=null){
            result=new Result(ResultCode.SUCCESS,pageBean);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;
    }
}
