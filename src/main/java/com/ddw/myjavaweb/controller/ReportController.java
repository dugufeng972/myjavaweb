package com.ddw.myjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddw.myjavaweb.pojo.GenderData;
import com.ddw.myjavaweb.pojo.JobOption;
import com.ddw.myjavaweb.pojo.Result;
import com.ddw.myjavaweb.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService ReportService;
    //统计员工信息
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        JobOption jobOption = ReportService.getEmpJobData();
        // jobOption
        return Result.success(jobOption);
    }
    //获取性别信息
    @GetMapping("genderData")
    public Result getEmpGenderData() {
        List<GenderData> list = ReportService.getEmpGenderData();
        return Result.success(list);
    }
}
