package com.cdivtc.service;

import com.cdivtc.model.CtClassTime;
import com.cdivtc.model.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CtClassTimeService {
    public int addClassTime(CtClassTime ctClassTime);
    public int deleteClassTime(String ctId);
    public int updateClassTime(CtClassTime ctClassTime);
    public PageBean<CtClassTime> findPage(Integer page, Integer row);
    public List<CtClassTime> findAll();
}
