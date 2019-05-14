package com.shape.singleproject.vo;

import lombok.Data;

/**
 * 标签分页查询对象
 */
@Data
public class TagPageQuery extends BaseQuery {
    /**
     * 标签名字
     */
    private String tagName;

    /**
     * 标签类型
     */
    private Integer tagType;
}
