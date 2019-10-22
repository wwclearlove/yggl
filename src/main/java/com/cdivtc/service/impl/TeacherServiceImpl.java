package com.cdivtc.service.impl;

import com.cdivtc.mapper.UUserMapper;
import com.cdivtc.model.UUser;
import com.cdivtc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    UUserMapper uUserMapper;
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
    public List<UUser> findTeacherByCourse(String course) {
        return uUserMapper.findTeacherByCourse(course);
    }
}
