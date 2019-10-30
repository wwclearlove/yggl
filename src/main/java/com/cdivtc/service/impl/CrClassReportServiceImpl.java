package com.cdivtc.service.impl;

import com.cdivtc.mapper.CrClassReportMapper;
import com.cdivtc.model.*;
import com.cdivtc.service.ClClassRoomService;
import com.cdivtc.service.CrClassReportService;
import com.cdivtc.service.CtClassTimeService;
import com.cdivtc.service.cClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CrClassReportServiceImpl implements CrClassReportService {
    @Autowired
    CrClassReportMapper crClassReportMapper;
    @Autowired
    CtClassTimeService timeService;
    @Autowired
    cClassService cClassService;
    @Autowired
    ClClassRoomService clClassRoomService;

    @Override
    public int addCrClassReport(CrClassReport crClassReport) {
        return crClassReportMapper.addCrClassReport(crClassReport);
    }

    @Override
    public int deleteCrClassReport(String crId) {
        return crClassReportMapper.deleteCrClassReport(crId);
    }

    @Override
    public int fuyuanCrClassReport(String crId) {
        return crClassReportMapper.fuyuanCrClassReport(crId);
    }

    @Override
    public int sheheCrClassReport(List<String> crIds) {
        int i=0;
        if(crIds!=null){
            for (String crid :
                    crIds) {
                System.out.println(crid);
                 i = crClassReportMapper.shengheCrClassReport(crid);
            }

        }
        return i;
    }

    @Override
    public int updateCrClassReport(CrClassReport crClassReport) {
        return crClassReportMapper.updateCrClassReport(crClassReport);
    }

    @Override
    public Map<String, List> findHebing() {
        Map<String, List> map=new HashMap<>();
        List<CClass> banji=new ArrayList<>();
        List<CtClassTime> shijian=new ArrayList<>();
        List<ClClassRoom> jiaos=new ArrayList<>();
        shijian=timeService.findAll();
        banji=cClassService.findAllClass();
        jiaos=clClassRoomService.findAllClassRoom();
        map.put("time",shijian);
        map.put("class",banji);
        map.put("room",jiaos);

        return map;
    }


    @Override
    public PageBean<CrClassReport> findAllCrClassReportByTeacher1(Integer page, Integer row, String teacher) {
        if (page <= 0) {
            page = 1;
            row = 5;
        }
        PageBean<CrClassReport> pb = new PageBean<CrClassReport>();
        pb.setRows(row);
        //调用查询总记录数
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("flag", 1);
        map1.put("teacher", teacher);
        int totalCout = crClassReportMapper.findAllCrClassReport(map1).size();
        if (totalCout == 0) {
            return null;
        } else {
            pb.setTotalCount(totalCout);
            //计算总页码
            int totalPage = (totalCout % row) == 0 ? totalCout / row : (totalCout / row) + 1;
            pb.setTotalPage(totalPage);
            if (page > totalPage) {
                page = totalPage;
            }
            pb.setCurrentPage(page);
            //调用dao查询list集合
            //计算开始的记录索引
            System.out.println(page + "页");
            int start = (page - 1) * row;
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", start);
            map.put("row", row);
            map.put("teacher", teacher);
            System.out.println("行数"+row+"页数"+totalPage);
            List<CrClassReport> list = crClassReportMapper.findAllCrClassReportByTeacherw(map);
            pb.setList(list);
        }
        return pb;

    }

    @Override
    public PageBean<CrClassReport> findAllCrClassReportByTeacher2(Integer page, Integer row, String teacher) {
        if (page <= 0) {
            page = 1;
            row = 5;
        }
        PageBean<CrClassReport> pb = new PageBean<CrClassReport>();
        pb.setRows(row);
        //调用查询总记录数
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("flag", 2);
        map1.put("teacher", teacher);
        int totalCout = crClassReportMapper.findAllCrClassReport(map1).size();
        if (totalCout == 0) {
            return null;
        } else {
            pb.setTotalCount(totalCout);
            //计算总页码
            int totalPage = (totalCout % row) == 0 ? totalCout / row : (totalCout / row) + 1;
            pb.setTotalPage(totalPage);
            if (page > totalPage) {
                page = totalPage;
            }
            pb.setCurrentPage(page);
            //调用dao查询list集合
            //计算开始的记录索引
            System.out.println(page + "页");
            int start = (page - 1) * row;
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", start);
            map.put("row", row);
            map.put("teacher", teacher);
            List<CrClassReport> list = crClassReportMapper.findAllCrClassReportByTeachery(map);
            pb.setList(list);
        }
        return pb;
    }

    @Override
    public PageBean<CrClassReport> findAllCrClassReportByTeacher0(Integer page, Integer row, String teacher) {
        if (page <= 0) {
            page = 1;
            row = 5;
        }
        PageBean<CrClassReport> pb = new PageBean<CrClassReport>();
        pb.setRows(row);
        //调用查询总记录数
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("flag", 0);
        map1.put("teacher", teacher);
        int totalCout = crClassReportMapper.findAllCrClassReport(map1).size();
        if (totalCout == 0) {
            return null;
        } else {
            pb.setTotalCount(totalCout);
            //计算总页码
            int totalPage = (totalCout % row) == 0 ? totalCout / row : (totalCout / row) + 1;
            pb.setTotalPage(totalPage);
            if (page > totalPage) {
                page = totalPage;
            }
            pb.setCurrentPage(page);
            //调用dao查询list集合
            //计算开始的记录索引
            System.out.println(page + "页");
            int start = (page - 1) * row;
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", start);
            map.put("row", row);
            map.put("teacher", teacher);
            List<CrClassReport> list = crClassReportMapper.findAllCrClassReportByTeachers(map);
            pb.setList(list);
        }
        return pb;
    }

    @Override
    public PageBean<TeacherSum> findPageCount(Integer page, Integer row) {
        if (page <= 0) {
            page = 1;
            row = 5;
        }
        PageBean<TeacherSum> pb = new PageBean<TeacherSum>();
        pb.setRows(row);
        //调用查询总记录数
        int totalCout = crClassReportMapper.findPageCountAll().size();
        if (totalCout == 0) {
            return null;
        } else {
            pb.setTotalCount(totalCout);
            //计算总页码
            int totalPage = (totalCout % row) == 0 ? totalCout / row : (totalCout / row) + 1;
            pb.setTotalPage(totalPage);
            if (page > totalPage) {
                page = totalPage;
            }
            pb.setCurrentPage(page);
            //调用dao查询list集合
            //计算开始的记录索引
            System.out.println(page + "页");
            int start = (page - 1) * row;
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", start);
            map.put("row", row);
            List<TeacherSum> pageCount = crClassReportMapper.findPageCount(map);
            pb.setList(pageCount);
        }
        return pb;
    }
}

