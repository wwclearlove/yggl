package com.cdivtc.mapper;

import com.cdivtc.model.CClass;
import com.cdivtc.model.CrClassReport;
import com.cdivtc.model.TeacherSum;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CrClassReportMapper {
    public int addCrClassReport(CrClassReport crClassReport);
    public int deleteCrClassReport(String crId);
    public int fuyuanCrClassReport(String crId);
    public int updateCrClassReport(@Param("crClassReport")CrClassReport crClassReport);

    public List<CrClassReport> findAllCrClassReport();
    public List<CrClassReport> findAllCrClassReportByTeacherw(Map<String,Object> map);
    public List<CrClassReport> findAllCrClassReportByTeachery(Map<String,Object> map);
    public List<CrClassReport> findAllCrClassReportByTeachers(Map<String,Object> map);
    public List<TeacherSum> findPageCount(Map<String,Object> map);
    public List<TeacherSum> findPageCountAll();

}