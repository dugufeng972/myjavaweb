package com.ddw.myjavaweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Result;
// import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ddw.myjavaweb.pojo.Dept;

@Mapper
public interface DeptMapper {
    // @Results({
    //     @Result(column = "create_time", property = "createTime"),
    //     @Result(column = "update_time", property = "updateTime")
        
    // })
    @Select("select * from dept order by update_time desc")
    public List<Dept> getAllDepts();
    @Delete("delete from dept where id=#{id}")
    public int delDepts(int id);
    //新增部门
    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    public void addDept(Dept dept);
    //通过id获取部门信息
    @Select("select * from dept where id=#{id}")
    public Dept getById(Integer id);
    //根据id修改部门名称
    @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    public void updateDept(Dept dept);

}
