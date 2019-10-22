package com.cdivtc.service;

import com.cdivtc.model.CClass;
import com.cdivtc.model.CCourse;
import com.cdivtc.model.PageBean;

import java.util.List;

public interface cCourseService {
    public int addCourse(CCourse cCourse);
    public int deleteCourse(String cId);
    public int updateCourse(CCourse cCourse);
    public PageBean<CCourse> findPageCourse(Integer page, Integer row);
    public List<CCourse> findAllCourse();
}
