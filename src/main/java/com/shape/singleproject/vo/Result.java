package com.shape.singleproject.vo;

import lombok.Data;

@Data
public class Result<T> {
    private boolean success;
    private String message;
    private T data;

    public static Result failResultWithDefaultMessage(){
        Result result = new Result();
        result.setMessage("服务器繁忙，请稍后再试试！");
        return result;
    }
    public static Result successResult(){
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }
}
