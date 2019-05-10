package com.shape.singleproject.domain;

import lombok.Data;

/**
 * 用户信息随机查询对象
 */
@Data
public class UserInfoRandomQuery {
    private Integer size = 1;
    private Integer doingTags;
    private Integer planTags;
    private Integer activityTags;
}
