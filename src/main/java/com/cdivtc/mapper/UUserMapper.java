package com.cdivtc.mapper;

import com.cdivtc.model.CCourse;
import com.cdivtc.model.UUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UUserMapper {

        public int addTeacher(UUser uUser);
        public int deleteTeacher(String uId);
        public int updateTeacher(@Param("uUser")UUser uUser);
        public List<UUser> findTeacher();
        public List<UUser> findTeacherByName(String name);
        public List<UUser> findTeacherByCourse(String course);
        public UUser findTeacherByUser(Map<String,Object> map);
        public UUser findTeacherByPassword(Map<String,Object> map);
        public UUser findTeacherByuId(Map<String,Object> map);
}
