package com.shape.singleproject.vo;

import lombok.Data;

@Data
public class BaseQuery {
    /**
     * 当前页
     */
    private int pageIndex = 1;
    /**
     * 页面显示个数
     */
    private int pageSize = 10;
}
