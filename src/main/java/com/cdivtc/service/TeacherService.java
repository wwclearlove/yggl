package com.cdivtc.service;

import com.cdivtc.model.CCourse;
import com.cdivtc.model.ImageHolder;
import com.cdivtc.model.UUser;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    public int addTeacher(UUser uUser);
    public int deleteTeacher(String uId);
    public int updateTeacher(UUser uUser);
    public List<UUser> findTeacher();
    public List<UUser> findTeacherByName(String name);
    public Map<String, List<UUser>> findTeacherByCourseList( );
    public UUser findTeacherByUsername(String username,int flag);
    public UUser findTeacherByPassword(String password,String uid);
    public UUser findTeacherByuId(String uId,int flag);
}
