package com.shape.singleproject.constant;

import java.util.Arrays;

public enum ReportStatusEnum {
    WAIT(0, "待审核"),
    SUCCESS(1, "审核通过"),
    FAIL(2, "驳回");
    private Integer status;
    private String desc;

    ReportStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }


    public static String getDescByStatus(Integer status) {
        return Arrays.stream(ReportStatusEnum.values())
                .filter(en -> en.getStatus().equals(status))
                .findFirst()
                .map(ReportStatusEnum::getDesc)
                .orElse(null);
    }
}
