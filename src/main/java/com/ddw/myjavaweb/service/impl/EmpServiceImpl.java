package com.ddw.myjavaweb.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddw.myjavaweb.mapper.EmpExprMapper;
import com.ddw.myjavaweb.mapper.EmpMapper;
import com.ddw.myjavaweb.pojo.Emp;
import com.ddw.myjavaweb.pojo.EmpExpr;
import com.ddw.myjavaweb.pojo.PageResult;
import com.ddw.myjavaweb.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Override
    public PageResult<Emp> find(Integer page, Integer pageSize, Integer gender, String name, LocalDate begin,
            LocalDate end) {
        PageHelper.startPage(page, pageSize);
        List<Emp> list = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) list;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
    @Override
    public void save(Emp emp) {
        //保存员工基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        //保存员工工作经验信息
        List<EmpExpr> empExprs = emp.getExprList();
        if (empExprs.size() != 0) {
            empExprs.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(empExprs);
        }
    }
}
