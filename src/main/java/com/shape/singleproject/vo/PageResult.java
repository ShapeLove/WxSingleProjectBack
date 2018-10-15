package com.shape.singleproject.vo;

import lombok.Data;

import java.util.List;

public class PageResult<T> {
    private boolean success;
    private String message;
    private List<T> dataList;
    private int totalPage;
    private long totalCount;

    public static PageResult build() {
        return new PageResult<>();
    }

    public PageResult<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public PageResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public PageResult<T> setDataList(List<T> dataList) {
        this.dataList = dataList;
        return this;
    }

    public PageResult<T> setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public PageResult<T> setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public long getTotalCount() {
        return totalCount;
    }
}
