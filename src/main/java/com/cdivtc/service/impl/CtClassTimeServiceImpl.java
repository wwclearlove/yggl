package com.cdivtc.service.impl;

import com.cdivtc.mapper.CtClassTimeMapper;
import com.cdivtc.model.CtClassTime;
import com.cdivtc.model.PageBean;
import com.cdivtc.service.CtClassTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class CtClassTimeServiceImpl implements CtClassTimeService {
    @Autowired
    CtClassTimeMapper ctClassTimeMapper;
    @Override
    public int addClassTime(CtClassTime ctClassTime) {
        return ctClassTimeMapper.addClassTime(ctClassTime);
    }

    @Override
    public int deleteClassTime(String ctId) {
        return ctClassTimeMapper.deleteClassTime(ctId);
    }

    @Override
    public int updateClassTime(CtClassTime ctClassTime) {
        return ctClassTimeMapper.updateClassTime(ctClassTime);
    }

    @Override
    public PageBean<CtClassTime> findPage(Integer page, Integer row) {
        if(page<=0){
            page=1;
            row=5;
        }

        PageBean<CtClassTime> pb=new PageBean<CtClassTime>();
        pb.setRows(row);
        //调用查询总记录数
        int totalCout=ctClassTimeMapper.findAll().size();
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
            List<CtClassTime> list= ctClassTimeMapper.findPage(map);
            pb.setList(list);
        }
        return pb;
    }


    @Override
    public List<CtClassTime> findAll() {
        return ctClassTimeMapper.findAll();
    }
}
