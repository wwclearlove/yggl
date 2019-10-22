package com.cdivtc.web.controller;

import com.cdivtc.model.*;
import com.cdivtc.service.CtClassTimeService;
import com.cdivtc.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/time")
public class CtClassController {
    @Autowired
    IdWorker idWorker;
    @Autowired
    CtClassTimeService ctClassTimeService;
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Result addCtClass(CtClassTime ctClassTime){

        ctClassTime.setCtId(idWorker.nextId()+"");
        int i = ctClassTimeService.addClassTime(ctClassTime);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/delete",method = RequestMethod.DELETE)
    public Result deleteCtClass(String ctId){
        int i = ctClassTimeService.deleteClassTime(ctId);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/update",method = RequestMethod.PUT)
    public Result updateCtClass(CtClassTime ctClassTime){
        int i = ctClassTimeService.updateClassTime(ctClassTime);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/findAll",method = RequestMethod.GET)
    public Result findAllCtClass(){
        Result result=null;
        List<CtClassTime> all = ctClassTimeService.findAll();
        if(all!=null){
            result=new Result(ResultCode.SUCCESS,all);
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
        PageBean<CtClassTime> pageBean= ctClassTimeService.findPage(page, row);
        if(pageBean!=null){
            result=new Result(ResultCode.SUCCESS,pageBean);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;
    }
}
