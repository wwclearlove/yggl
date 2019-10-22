package com.cdivtc.mapper;

import com.cdivtc.model.UUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UUserMapper {

        public int addTeacher(UUser uUser);
        public int deleteTeacher(String uId);
        public int updateTeacher(@Param("uUser")UUser uUser);
        public List<UUser> findTeacher();
        public List<UUser> findTeacherByCourse(String course);

}
