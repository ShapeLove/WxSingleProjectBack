package com.shape.singleproject.vo;

import lombok.Data;

/**
 * 管理端分页查询用户信息对象
 */
@Data
public class AdminUserQuery extends BaseQuery {
    /**
     * 用户名称
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 学历
     */
    private Integer education;
    /**
     * 是否有效
     */
    private Integer yn;
    /**
     * 审核状态
     */
    private Integer status;
    /**
     * 星座
     */
    private Integer constellation;
    /**
     * 微信号
     */
    private String wxNumber;
    /**
     * 咚咚号
     */
    private String dongdong;
}
