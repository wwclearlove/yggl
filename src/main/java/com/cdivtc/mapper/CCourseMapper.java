package com.cdivtc.mapper;

import com.cdivtc.model.CClass;
import com.cdivtc.model.CCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CCourseMapper {
    public int addCourse(CCourse cCourse);
    public int deleteCourse(String cId);
    public int updateCourse(@Param("cCourse")CCourse cCourse);
    public List<CCourse> findPageCourse(Map<String,Object> map);
    public List<CCourse> findAllCourse();
}