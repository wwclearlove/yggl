package com.cdivtc.service.impl;

import com.cdivtc.mapper.CClassMapper;
import com.cdivtc.model.CClass;
import com.cdivtc.model.PageBean;
import com.cdivtc.service.cClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CClassServiceImpl implements cClassService {
    @Autowired
    CClassMapper cClassMapper;

    @Override
    public int addClass(CClass cClass) {
        return cClassMapper.addClass(cClass);
    }

    @Override
    public CClass findByname(String cName) {
        return cClassMapper.findClassByname(cName);
    }

    @Override
    public int deleteClass(String cId) {
        return cClassMapper.deleteClass(cId);
    }

    @Override
    public int updateClass(CClass cClass) {
        return cClassMapper.updateClass(cClass);
    }

    @Override
    public PageBean<CClass> findPage(Integer page, Integer row) {

        if(page<=0){
            page=1;
            row=5;
        }

        PageBean<CClass> pb=new PageBean<CClass>();
        pb.setRows(row);
        //调用查询总记录数
        int totalCout=cClassMapper.findAllClass().size();
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
            List<CClass> list= cClassMapper.findPageClass(map);
            pb.setList(list);
        }
        return pb;
    }

    @Override
    public List<CClass> findAllClass() {
        return cClassMapper.findAllClass();
    }
}
