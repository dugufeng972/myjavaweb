package com.ddw.myjavaweb.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddw.myjavaweb.pojo.Emp;
import com.ddw.myjavaweb.pojo.EmpQueryParam;
import com.ddw.myjavaweb.pojo.PageResult;
import com.ddw.myjavaweb.pojo.Result;
import com.ddw.myjavaweb.service.EmpService;

import lombok.extern.slf4j.Slf4j;

//员工管理controller
// @Slf4j
@RestController
@RequestMapping("/emps")

public class EmpController {
    @Autowired
    private EmpService EmpService;
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        // log.info("分页查询：{},{}", page, pageSize);
        PageResult<Emp> pageResult = EmpService.find(empQueryParam.getPage(), empQueryParam.getPageSize(), empQueryParam.getGender(), empQueryParam.getName(), empQueryParam.getBegin(), empQueryParam.getEnd());
        return Result.success(pageResult);
    }
    // @RequestParam(defaultValue = "1") Integer page, 
    // @RequestParam(defaultValue = "5") Integer pageSize,
    // Integer gender,
    // String name,
    // @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
    // @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    // @PostMapping
    // public Result savePost(@RequestBody Emp emp) {
    //     // EmpService.save(emp);
    //     EmpService.save(emp);
    //     return Result.success();
    // }
    //删除员工
    @DeleteMapping
    //接收数组方法一
    // public Result delete(@RequestParam List<Integer> ids) {

    //     return Result.success();
    // }
    public Result delete(Integer[] ids) {
        System.out.println(Arrays.toString(ids));
        EmpService.delete(ids);
        return Result.success();
    }
    //根据员工id查询信息
    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable("id") Integer id) {
        Emp emp = EmpService.getInfoById(id);
        return Result.success(emp);
    }
    //修改员工信息
    @PostMapping
    public Result update(@RequestBody Emp emp){
        EmpService.update(emp);
        return Result.success();
    }
}
