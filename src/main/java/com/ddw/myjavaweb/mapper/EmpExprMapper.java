package com.ddw.myjavaweb.mapper;

import java.util.List;

// import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.ddw.myjavaweb.pojo.EmpExpr;

@Mapper
public interface EmpExprMapper {
    
    void insertBatch(List<EmpExpr> empExprs);
    
}
