package com.shape.singleproject.dto;

import lombok.Data;

/**
 * 按照时间统计数量
 */
@Data
public class DateCountDo {
    private String dateString;
    private Integer value;
}
