package com.cdivtc.web.controller;

import com.cdivtc.model.*;
import com.cdivtc.service.CrClassReportService;
import com.cdivtc.service.cClassService;
import com.cdivtc.util.DateUtil;
import com.cdivtc.util.IdWorker;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/report")
public class CrClassReportController {
    @Autowired
    IdWorker idWorker;
    @Autowired
    CrClassReportService crClassReportService;

    @RequestMapping(value = "/shenghe", method = RequestMethod.PUT)
    public Result shehenCrClassReport(@RequestBody Map<String,Object> map) {
      List<String> ss= (List<String>) map.get("listId");
        System.out.println(ss);
        if(ss!=null){
            int i = crClassReportService.sheheCrClassReport(ss);
            if (i == 1) {
                return Result.SUCCESS();
            } else {
                return Result.FAIL();
            }
        }else {
            return Result.ERROR();
        }
    }





    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addCrClassReport(@RequestBody CrClassReport crClassReport) {
        crClassReport.setCrId(idWorker.nextId() + "");
        try {
            crClassReport.setCrWeek(DateUtil.dateToWeek(crClassReport.getCrDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        crClassReport.setCrFlag(1);
        int i = crClassReportService.addCrClassReport(crClassReport);
        if (i == 1) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteCrClassReport(@RequestBody Map<String,Object> map) {
        String  cId= (String) map.get("crId");
        System.out.println(cId);
        int i = crClassReportService.deleteCrClassReport(cId);
        if (i == 1) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result updateCrClassReport(@RequestBody CrClassReport crClassReport) throws ParseException {
        System.out.println(crClassReport);
        if (!crClassReport.getCrDate() .equals("")|| !crClassReport.getCrDate().isEmpty()) {
            crClassReport.setCrWeek(DateUtil.dateToWeek(crClassReport.getCrDate()));
        }
        int i = crClassReportService.updateCrClassReport(crClassReport);
        if (i == 1) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }
    @RequestMapping(value = "/prevData", method = RequestMethod.GET)
    public Result prevData() {
        Result result=new Result();
        Map<String, List> hebing = crClassReportService.findHebing();
        if(hebing!=null){
            result.setData(hebing);
            result.setSuccess(true);
        }else {
            result.setMessage("无数据");
            result.setSuccess(false);
        }
        return result;
    }
    @RequestMapping(value = "/fuyuan", method = RequestMethod.GET)
    public Result fuyuanCrClassReport(String cId) {
        System.out.println(cId);
        int i = crClassReportService.fuyuanCrClassReport(cId);
        if (i == 1) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }
    @RequestMapping(value ="/findPageByTeacher1",method = RequestMethod.GET)
    public Result findPage1(@Param("page") Integer page, @Param("row")Integer row, @Param("crTeacher")String crTeacher){
        Result result=null;
        System.out.println(page+"--"+row+"pythone");
        if(page<=0){
            page=1;
            row=5;
        }
        if(page==null){
            page=1;
        }
        if(row==null){
            row=5;
        }
        PageBean<CrClassReport> allCrClassReportByTeacher1 = crClassReportService.findAllCrClassReportByTeacher1(page, row, crTeacher);
        if(allCrClassReportByTeacher1!=null){
            result=new Result(ResultCode.SUCCESS,allCrClassReportByTeacher1);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;
    }
    @RequestMapping(value ="/findPageByTeacher0",method = RequestMethod.GET)
    public Result findPage0(@Param("page") Integer page, @Param("row")Integer row, @Param("crTeacher")String crTeacher){
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
        PageBean<CrClassReport> allCrClassReportByTeacher0 = crClassReportService.findAllCrClassReportByTeacher0(page, row, crTeacher);
        if(allCrClassReportByTeacher0!=null){
            result=new Result(ResultCode.SUCCESS,allCrClassReportByTeacher0);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;
    }
    @RequestMapping(value ="/findPageByTeacher2",method = RequestMethod.GET)
    public Result findPage2(@Param("page") Integer page, @Param("row")Integer row, @Param("crTeacher")String crTeacher){
        Result result=null;
        if(page<=0){
            page=1;
            row=5;
        }
        if(page==null){
            page=1;
        }
        if(row==null){
            row=5;
        }
        PageBean<CrClassReport> allCrClassReportByTeacher2 = crClassReportService.findAllCrClassReportByTeacher2(page, row, crTeacher);
        if(allCrClassReportByTeacher2!=null){
            result=new Result(ResultCode.SUCCESS,allCrClassReportByTeacher2);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;
    }
    @RequestMapping(value ="/findCountPage",method = RequestMethod.GET)
    public Result findCountPage(@Param("page") Integer page, @Param("row")Integer row){
        Result result=null;
        if(page<=0){
            page=1;
            row=5;
        }
        if(page==null){
            page=1;
        }
        if(row==null){
            row=5;
        }
        PageBean<TeacherSum> pageCount = crClassReportService.findPageCount(page, row);
        if(pageCount!=null){
            result=new Result(ResultCode.SUCCESS,pageCount);
        }else {
            result=new Result(ResultCode.FAIL);
        }
        return result;
    }
}
