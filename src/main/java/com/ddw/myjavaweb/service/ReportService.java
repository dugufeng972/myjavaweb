package com.ddw.myjavaweb.service;

import java.util.List;

import com.ddw.myjavaweb.pojo.GenderData;
import com.ddw.myjavaweb.pojo.JobOption;

public interface ReportService {

    JobOption getEmpJobData();

    List<GenderData> getEmpGenderData();
    
}
