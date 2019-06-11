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
    // 总数
    private long totalCount;
    // 时间序列
    private List<String> dateKeyList = Lists.newArrayList();
    // 与时间序列对应的数量
    private List<Integer> dataList = Lists.newArrayList();
}
