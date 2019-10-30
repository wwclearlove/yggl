package com.cdivtc.service.impl;

import com.cdivtc.mapper.CClassMapper;
import com.cdivtc.mapper.CCourseMapper;
import com.cdivtc.model.CClass;
import com.cdivtc.model.CCourse;
import com.cdivtc.model.PageBean;
import com.cdivtc.service.cCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class cCourseServiceImpl implements cCourseService {
    @Autowired
    CCourseMapper cCourseMapper;

    @Override
    public int addCourse(CCourse cCourse) {
        return cCourseMapper.addCourse(cCourse);
    }

    @Override
    public CCourse findByname(String cName) {
        return cCourseMapper.findCourseByname(cName);
    }

    @Override
    public int deleteCourse(String cId) {
        return cCourseMapper.deleteCourse(cId);
    }

    @Override
    public int updateCourse(CCourse cCourse) {
        return cCourseMapper.updateCourse(cCourse);
    }

    @Override
    public PageBean<CCourse> findPageCourse(Integer page, Integer row) {
        if(page<=0){
            page=1;
            row=5;
        }
        PageBean<CCourse> pb=new PageBean<CCourse>();
        pb.setRows(row);
        //调用查询总记录数
        int totalCout=cCourseMapper.findAllCourse().size();
        if(totalCout==0){
            return null;
        }else {
            pb.setTotalCount(totalCout);
            //计算总页码
            int totalPage=(totalCout%row )==0?totalCout/row:(totalCout/row)+1;
            pb.setTotalPage(totalPage);
            if(page>totalPage){
                page=totalPage;
            }
            pb.setCurrentPage(page);
            //调用dao查询list集合
            //计算开始的记录索引
            System.out.println(page+"页");
            int start=(page-1)*row;
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("start",start);
            map.put("row",row);
            List<CCourse> list= cCourseMapper.findPageCourse(map);
            pb.setList(list);
        }
        return pb;
    }

    @Override
    public List<CCourse> findAllCourse() {
        return cCourseMapper.findAllCourse();
    }
}
