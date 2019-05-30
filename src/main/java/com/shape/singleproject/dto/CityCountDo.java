package com.shape.singleproject.dto;

import lombok.Data;

/**
 * 统计城市用户数据Vo
 */
@Data
public class CityCountDo {
    /**
     * 所在城市名称
     */
    private String name;
    /**
     * 具体用户个数
     */
    private Integer value;
}
