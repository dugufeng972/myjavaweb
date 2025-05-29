package com.ddw.myjavaweb.service;

import java.util.List;

import com.ddw.myjavaweb.pojo.Dept;

public interface DeptService {
    //查找所有部门
    List<Dept> findAll();
    //删除部门
    boolean delDepts(int id);
    //新增部门
    void addDept(Dept dept);
    //通过id获取部门信息
    Dept getById(Integer id);
    //根据id修改部门名称
    void updateDept(Dept dept);
}
