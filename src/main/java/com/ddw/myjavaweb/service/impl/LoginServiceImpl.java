package com.ddw.myjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddw.myjavaweb.mapper.EmpMapper;
import com.ddw.myjavaweb.pojo.Emp;
import com.ddw.myjavaweb.pojo.LoginInfo;
import com.ddw.myjavaweb.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private EmpMapper empMapper;
    @Override
    public LoginInfo login(Emp emp) {
        // TODO Auto-generated method stub
        return null;
    }
}
