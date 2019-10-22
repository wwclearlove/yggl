package com.cdivtc.web.controller;

import com.cdivtc.model.*;
import com.cdivtc.service.CtClassTimeService;
import com.cdivtc.util.IdWorker;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/time")
public class CtClassController {
    @Autowired
    IdWorker idWorker;
    @Autowired
    CtClassTimeService ctClassTimeService;
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Result addCtClass(@RequestBody CtClassTime ctClassTime){

        ctClassTime.setCtId(idWorker.nextId()+"");
        int i = ctClassTimeService.addClassTime(ctClassTime);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/delete",method = RequestMethod.DELETE)
    public Result deleteCtClass(@RequestBody Map<String,Object> map){
        String  ctId= (String) map.get("ctId");
        int i = ctClassTimeService.deleteClassTime(ctId);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/update",method = RequestMethod.PUT)
    public Result updateCtClass(@RequestBody CtClassTime ctClassTime){
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
    public Result findPage(@Param("page") Integer page, @Param("row")Integer row){

//       Integer cupage=page;
//       Integer curow=row;
        System.out.println(page+"多少");
        System.out.println(row+"多少");
        if(page<=0){
            page=1;
            row=5;
        }

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
