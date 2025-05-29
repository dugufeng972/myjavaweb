package com.ddw.myjavaweb.pojo;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result success(Object obj) {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        result.data = obj;
        return result;
    }
    public static Result error(String err) {
        Result result = new Result();
        result.code = 0;
        result.msg = err;
        // result.data = obj;
        return result;
    }
}
