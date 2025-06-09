package com.ddw.myjavaweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddw.myjavaweb.mapper.EmpMapper;
import com.ddw.myjavaweb.pojo.GenderData;
import com.ddw.myjavaweb.pojo.JobOption;
import com.ddw.myjavaweb.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private EmpMapper empMapper;
    //统计员工信息
    @Override
    public JobOption getEmpJobData() {
        /*查询到的sql表结构
        pos         num
        教研主管     1
        学工主管     1
        其他         1
        Map的结构
        pos=学工主管 num=1
        list的结构
        pos=教研主管 num=1，pos=学工主管 num=1。。。
        */
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(el -> el.get("pos")).toList();
        List<Object> dataList = list.stream().map(el -> el.get("num")).toList();
        return new JobOption(jobList, dataList);
    }
    //获取性别信息
    @Override
    public List<GenderData> getEmpGenderData() {
        List<GenderData> list = empMapper.getEmpGenderData();
        return list;
    }
}
