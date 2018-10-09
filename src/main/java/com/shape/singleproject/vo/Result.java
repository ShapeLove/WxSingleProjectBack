package com.shape.singleproject.vo;

import lombok.Data;

@Data
public class Result<T> {
    private boolean success;
    private String message;
    private T data;
}
