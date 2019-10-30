package com.cdivtc.service.impl;

import com.cdivtc.mapper.CCourseMapper;
import com.cdivtc.mapper.UUserMapper;
import com.cdivtc.model.CCourse;
import com.cdivtc.model.UUser;
import com.cdivtc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    UUserMapper uUserMapper;
    @Autowired
    CCourseMapper cCourseMapper;

    @Override
    public int addTeacher(UUser uUser) {

        return uUserMapper.addTeacher(uUser);
    }

    @Override
    public int deleteTeacher(String uId) {
        return  uUserMapper.deleteTeacher(uId);
    }

    @Override
    public int updateTeacher(UUser uUser) {
        return uUserMapper.updateTeacher(uUser);
    }

    @Override
    public List<UUser> findTeacher() {
        return uUserMapper.findTeacher();
    }

    @Override
    public List<UUser> findTeacherByName(String name) {
        if(!name.equals("")){
            name="%"+name+"%";
        }
        return uUserMapper.findTeacherByName(name);
    }

    @Override
    public Map<String, List<UUser>> findTeacherByCourseList() {

        Map<String, List<UUser>> map=new HashMap<>();
        List<CCourse> allCourse = cCourseMapper.findAllCourse();
        for (CCourse  c: allCourse) {
            List<UUser> teacherByCourse = uUserMapper.findTeacherByCourse(c.getcName());
            map.put(c.getcName(),teacherByCourse);

        }
        return map;
    }

    @Override
    public UUser findTeacherByUsername(String username, int flag) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("username",username);
        map.put("flag",flag);
        return uUserMapper.findTeacherByUser(map);
    }

    @Override
    public UUser findTeacherByPassword(String password, String uid) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("uId",uid);
        map.put("uPassword",password);
        return uUserMapper.findTeacherByPassword(map);
    }

    @Override
    public UUser findTeacherByuId(String uId, int flag) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("uId",uId);
        map.put("flag",flag);
        return uUserMapper.findTeacherByuId(map);

    }


}
