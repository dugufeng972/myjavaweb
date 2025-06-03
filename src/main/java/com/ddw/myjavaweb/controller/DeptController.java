package com.ddw.myjavaweb.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ddw.myjavaweb.pojo.Dept;
import com.ddw.myjavaweb.pojo.Result;
import com.ddw.myjavaweb.service.DeptService;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

// import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    // @RequestMapping(path="/depts", method=RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        List<Dept> dList = deptService.findAll();
        // Result res = new Result();
        return Result.success(dList);
    }
    // @DeleteMapping("/depts")
    // public Result delDepts(HttpServletRequest request) {
    //     String idString = request.getParameter("id");
    //     int id = Integer.parseInt(idString);
    //     if (deptService.delDepts(id)) {
    //         return Result.success(null);
    //     }
    //     return Result.error("删除失败");
    // }
    @DeleteMapping("/depts")
    public Result delDepts(@RequestParam("id") Integer id) {
        if (deptService.delDepts(id)) {
            return Result.success(null);
        }
        return Result.error("删除失败");
    }
    @PostMapping("/depts")
    public Dept addDept(@RequestBody Dept dept) {
        deptService.addDept(dept);
        // System.out.println(dept);
        return dept;
    }
    //根据id查询部门
    @GetMapping("/depts/{id}")
    public Result getinfo(@PathVariable("id") Integer id) {
        // System.out.println(id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    //根据id修改部门名称
    @PutMapping("/depts")
    public String updateDept(@RequestBody Dept dept) {
        deptService.updateDept(dept);
        System.out.println(dept);
        return null;
    }
    //测试文件上传
    @PostMapping("/upload")
    public void upload(MultipartFile file) throws IOException {
        // System.out.println("文件二进制:");
        // System.out.println(file.getBytes()[0]);
        String fileName = UUID.randomUUID().toString();
        fileName = fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        System.out.println(fileName);
        file.transferTo(new File("C:\\Users\\dwl\\Desktop\\upload\\" + fileName));
    }
}
