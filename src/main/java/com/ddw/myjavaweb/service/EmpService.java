package com.ddw.myjavaweb.service;

import java.time.LocalDate;

import com.ddw.myjavaweb.pojo.Emp;
import com.ddw.myjavaweb.pojo.PageResult;

public interface EmpService {

    PageResult<Emp> find(Integer page, Integer pageSize, Integer gender, String name, LocalDate begin, LocalDate end);

    void save(Emp emp);

    void delete(Integer[] ids);

    Emp getInfoById(Integer id);

    void update(Emp emp);
    
}
