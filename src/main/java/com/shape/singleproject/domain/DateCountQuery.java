package com.shape.singleproject.domain;

import com.shape.singleproject.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 按时间统计查询数据查询对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateCountQuery {
    /**
     * 起始时间 从这个时间起往前推size天
     */
    private String targetDate = DateUtil.getNowDateString();
    private Integer size = 7;
}
