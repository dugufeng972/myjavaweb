package com.ddw.myjavaweb.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddw.myjavaweb.mapper.DeptMapper;
import com.ddw.myjavaweb.pojo.Dept;
import com.ddw.myjavaweb.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.getAllDepts();
    }
    @Override
    public boolean delDepts(int id) {
        int i = deptMapper.delDepts(id);
        return i == 0 ? false : true;
    }
    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }
    //通过id获取部门信息
    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }
    //根据id修改部门名称
    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }
}
