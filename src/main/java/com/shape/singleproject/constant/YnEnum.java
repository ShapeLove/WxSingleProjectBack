package com.shape.singleproject.constant;

/**
 * 是否有效枚举
 */
public enum  YnEnum {
    YN(0, "正常"),
    UNYN(1, "封禁");
    private int code;
    private String desc;

    YnEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
