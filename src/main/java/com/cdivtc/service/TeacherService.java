package com.cdivtc.service;

import com.cdivtc.model.UUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {
    public int addTeacher(UUser uUser);
    public int deleteTeacher(String uId);
    public int updateTeacher(UUser uUser);
    public List<UUser> findTeacher();
    public List<UUser> findTeacherByCourse(String course);
}
