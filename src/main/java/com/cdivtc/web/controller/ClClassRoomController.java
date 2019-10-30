package com.cdivtc.web.controller;

import com.cdivtc.model.*;
import com.cdivtc.service.ClClassRoomService;
import com.cdivtc.service.cClassService;
import com.cdivtc.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/room")
public class ClClassRoomController {
    @Autowired
    IdWorker idWorker;
    @Autowired
    ClClassRoomService clClassRoomService;
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Result addCtClass(@RequestBody ClClassRoom clClassRoom){
        Result result=new Result();
        System.out.println(clClassRoom);
        if(clClassRoom.getClRoom().equals("")||clClassRoom.getClRoom().isEmpty()){
            result.setMessage("添加的教室不能为空");
            result.setSuccess(false);
            return result;
        }
        ClClassRoom byname = clClassRoomService.findByname(clClassRoom.getClRoom());
        if(byname!=null){
            result.setMessage("添加的教室名称不能相同");
            result.setSuccess(false);
            return result;
        }
        clClassRoom.setClId(idWorker.nextId()+"");
        int i = clClassRoomService.addClassRoom(clClassRoom);
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
        int i = clClassRoomService.deleteClassRoom(cId);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/update",method = RequestMethod.PUT)
    public Result updateCtClass(@RequestBody ClClassRoom clClassRoom){
        System.out.println(clClassRoom);
        int i = clClassRoomService.updateClassRoom(clClassRoom);
        if(i==1){
            return Result.SUCCESS();
        }else {
            return  Result.FAIL();
        }
    }
    @RequestMapping(value ="/findAll",method = RequestMethod.GET)
    public Result findAllCtClass(){
        Result result=null;
        List<ClClassRoom> allClass =clClassRoomService.findAllClassRoom();
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

        PageBean<ClClassRoom> pageBean= clClassRoomService.findPageClassRoom(page, row);
        if(pageBean!=null){
            result=new Result(ResultCode.SUCCESS,pageBean);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;
    }
}
