package com.ddw.myjavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddw.myjavaweb.pojo.Emp;
import com.ddw.myjavaweb.pojo.LoginInfo;
import com.ddw.myjavaweb.pojo.Result;
import com.ddw.myjavaweb.service.EmpService;
// import com.ddw.myjavaweb.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
    // @Autowired
    // private LoginService loginService;
    @Autowired
    private EmpService empService;
    //登录请求
    @PostMapping
    public Result login(@RequestBody Emp emp){
        LoginInfo info = empService.login(emp);
        if (info != null) {
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }
}
