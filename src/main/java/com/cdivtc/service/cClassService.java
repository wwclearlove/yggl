package com.cdivtc.service;

import com.cdivtc.model.CClass;
import com.cdivtc.model.CtClassTime;
import com.cdivtc.model.PageBean;

import java.util.List;

public interface cClassService {
    public int addClass(CClass cClass);
    public int deleteClass(String cId);
    public int updateClass(CClass cClass);
    public PageBean<CClass> findPage(Integer page, Integer row);
    public List<CClass> findAllClass();
}
