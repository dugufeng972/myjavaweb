package com.ddw.myjavaweb.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOption {
    // public JobOption(List<Object> jobList, List<Object> dataList) {
    //     //TODO Auto-generated constructor stub

    // }
    private List<Object> jobList;
    private List<Object> dataList;
}
