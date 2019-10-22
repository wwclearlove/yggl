package com.cdivtc.web.controller;

import com.cdivtc.model.*;
import com.cdivtc.service.cClassService;
import com.cdivtc.util.IdWorker;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/class")
public class ClassController {
    @Autowired
    IdWorker idWorker;
    @Autowired
    cClassService cClassService;
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Result addCtClass(@RequestBody CClass cClass){
        System.out.println(cClass);
        cClass.setcId(idWorker.nextId()+"");
        int i = cClassService.addClass(cClass);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }

    @RequestMapping(value ="/delete",method = RequestMethod.DELETE)
    public Result deleteCtClass(@RequestBody Map<String,Object> map){
      String  cId= (String) map.get("cId");
        System.out.println(cId+"cid");
        int i = cClassService.deleteClass(cId);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/update",method = RequestMethod.PUT)
    public Result updateCtClass(@RequestBody CClass cClass){
        System.out.println(cClass);
        int i = cClassService.updateClass(cClass);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/findAll",method = RequestMethod.GET)
    public Result findAllCtClass(){
        Result result=null;
        List<CClass> allClass =cClassService.findAllClass();
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
        System.out.println(page+"空");
        System.out.println(row+"空");
        if(page==null){
            page=1;
        }
        if(row==null){
            row=5;
        }
        System.out.println(page);
        System.out.println(row);

        PageBean<CClass> pageBean= cClassService.findPage(page, row);
        if(pageBean!=null){
            result=new Result(ResultCode.SUCCESS,pageBean);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;
    }
}
