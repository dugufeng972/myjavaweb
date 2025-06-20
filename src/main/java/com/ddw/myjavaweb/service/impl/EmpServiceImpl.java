package com.ddw.myjavaweb.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddw.myjavaweb.mapper.EmpExprMapper;
import com.ddw.myjavaweb.mapper.EmpMapper;
import com.ddw.myjavaweb.pojo.Emp;
import com.ddw.myjavaweb.pojo.EmpExpr;
import com.ddw.myjavaweb.pojo.LoginInfo;
import com.ddw.myjavaweb.pojo.PageResult;
import com.ddw.myjavaweb.service.EmpService;
import com.ddw.myjavaweb.utils.JwtUtils;
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
    //删除员工
    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void delete(Integer[] ids) {
        // TODO Auto-generated method stub
        empMapper.deleteById(ids);
    }
    //根据员工id查询信息
    @Override
    public Emp getInfoById(Integer id) {
        // TODO Auto-generated method stub
        Emp emp = empMapper.getInfoById(id);
        return emp;
    }
    //修改员工信息
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        //先删除信息
        // empMapper
        empMapper.delBeforeUpdate(emp);
    }
    //登录查询
    @Override
    public LoginInfo login(Emp emp) {
        Emp usr = empMapper.selectByUsernameAndPasswd(emp);
        if (usr != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", usr.getId());
            claims.put("username", usr.getUsername());
            try {
                return new LoginInfo(usr.getId(), usr.getUsername(), usr.getName(), JwtUtils.generateToken(claims));
            } catch (Exception e) {
                e.printStackTrace();
                // 可以根据需要抛出自定义异常或返回错误信息
            }
        }
        return null;
    }
}
