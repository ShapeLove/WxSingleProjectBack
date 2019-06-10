package com.shape.singleproject.vo;

import lombok.Data;

/**
 * 通用结果集
 * @param <T>
 */
@Data
public class Result<T> {
    /**
     * 操作是否成功标识
     */
    private boolean success;
    /**
     * 不成功的错误信息
     */
    private String message;
    /**
     * 成功时带有的数据
     */
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

        public static <R> Result<R> successResultWithData(R data){
            Result<R> result = new Result<>();
            result.setSuccess(true);
            result.setData(data);
            return result;
        }

        public static Result failtResult(String message){
            Result result = new Result();
            result.setMessage(message);
            return result;
    }
}
