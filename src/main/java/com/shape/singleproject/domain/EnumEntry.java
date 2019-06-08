package com.shape.singleproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前端枚举单值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnumEntry {
    /**
     * 枚举值
     */
    private Integer value;
    /**
     * 描述
     */
    private String desc;
}
