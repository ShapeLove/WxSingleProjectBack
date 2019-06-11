package com.shape.singleproject.vo;

import lombok.Data;

/**
 * 管理端-管理员分页查询对象
 */
@Data
public class AdminUserPageQuery extends BaseQuery {
    // 管理员名字
    private String name;
    // 管理员级别
    private Integer level;
}
