package com.shape.singleproject.vo;

import lombok.Data;

@Data
public class ReportPageQuery extends BaseQuery {
    private String openId;
    private String reportOpenId;
    private Integer status;
}
