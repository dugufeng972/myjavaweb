package com.ddw.myjavaweb.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.ddw.myjavaweb.pojo.Emp;

/*
 * 员工sql查询
 */
@Mapper
public interface EmpMapper {
    //查询总记录数
    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
    public Long count();
    //分页查询
    // @Select("select emp.*, dept.name as 'deptName' from emp left join dept on emp.dept_id = dept.id limit #{start}, #{pageSize}")
    // public List<Emp> list(Integer start, Integer pageSize);
    //分页查询pagehelper
    // @Select("select emp.*, dept.name as 'deptName' from emp left join dept on emp.dept_id = dept.id where emp.name like '%#{name}%' and emp.gender=#{gender}")
    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    @Options(useGeneratedKeys = true, keyProperty = "id")   //获取生成的主键，并保存到emp对象中的id上
    @Insert("insert into emp (username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " + 
    "values (#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);
    public void deleteById(Integer[] ids);
}
