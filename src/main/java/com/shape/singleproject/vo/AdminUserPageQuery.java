package com.shape.singleproject.vo;

import lombok.Data;

@Data
public class AdminUserPageQuery extends BaseQuery {
    private String name;
    private Integer level;
}
