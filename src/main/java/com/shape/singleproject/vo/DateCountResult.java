package com.shape.singleproject.vo;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 计算数量
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateCountResult {
    private long totalCount;
    private List<String> dateKeyList = Lists.newArrayList();
    private List<Integer> dateList = Lists.newArrayList();
}
