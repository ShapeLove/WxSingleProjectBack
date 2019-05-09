package com.shape.singleproject.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 根据时间滚动加载查询参数
 */
@Data
public class UserInfoScrollQuery {
    private LocalDateTime createGt;
    private LocalDateTime createLt;
    private Integer size = 5;
}
