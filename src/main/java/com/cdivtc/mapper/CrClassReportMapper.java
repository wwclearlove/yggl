package com.cdivtc.mapper;

import com.cdivtc.model.CClass;
import com.cdivtc.model.CrClassReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CrClassReportMapper {
    public int addClassReport(CrClassReport crClassReport);
    public int deleteClassReport(String crId);
    public int updateClassReport(@Param("crClassReport")CrClassReport crClassReport);
    public List<CrClassReport> findPageClassReport(Map<String,Object> map);
    public List<CrClassReport> findAllClassReport();
    public List<CrClassReport> findAllClassReportByTeacher(Map<String,Object> map);
}