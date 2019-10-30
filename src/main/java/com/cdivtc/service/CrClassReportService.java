package com.cdivtc.service;

import com.cdivtc.model.CrClassReport;
import com.cdivtc.model.PageBean;
import com.cdivtc.model.TeacherSum;

import java.util.List;
import java.util.Map;

public interface CrClassReportService {
    public int addCrClassReport(CrClassReport crClassReport);
    public int deleteCrClassReport(String crId);
    public int fuyuanCrClassReport(String crId);
    public int sheheCrClassReport(List<String> crIds);
    public int updateCrClassReport(CrClassReport crClassReport);
    public Map<String, List> findHebing();
    public PageBean<CrClassReport> findAllCrClassReportByTeacher1(Integer page, Integer row,String teacher);
    public PageBean<CrClassReport> findAllCrClassReportByTeacher2(Integer page, Integer row,String teacher);
    public PageBean<CrClassReport> findAllCrClassReportByTeacher0(Integer page, Integer row,String teacher);
    public PageBean<TeacherSum> findPageCount(Integer page, Integer row );

}
