package com.cdivtc.mapper;

import com.cdivtc.model.CtClassTime;
import com.cdivtc.model.UUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CtClassTimeMapper {
    public int addClassTime(CtClassTime ctClassTime);
    public int deleteClassTime(String ctId);
    public int updateClassTime(@Param("ctClassTime")CtClassTime ctClassTime);
    public List<CtClassTime> findPage(Map<String,Object> map);
    public List<CtClassTime> findAll();
}