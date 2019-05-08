package com.shape.singleproject.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data //因为类中定义的是私有变量，所以无法直接访问，data标签默认添加了get和set方法，不用自己手动填
public class TestExceptInfo {
    private Long id;
    private String invocationName;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private String lastExceptMessage;
    private Integer exceptNum;
}
