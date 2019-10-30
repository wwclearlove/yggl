package com.cdivtc.mapper;

import com.cdivtc.model.CClass;
import com.cdivtc.model.CtClassTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CClassMapper {
    public int addClass(CClass cClass);
    public CClass findClassByname(String cName);
    public int deleteClass(String cId);
    public int updateClass(@Param("cClass")CClass cClass);
    public List<CClass> findPageClass(Map<String,Object> map);
    public List<CClass> findAllClass();
}