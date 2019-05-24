package com.shape.singleproject.constant;

import java.util.Arrays;

/**
 * 性别枚举
 */
public enum SexEnum {
    BOY(0, "男"),
    GIRL(1, "女");

    private int code;
    private String description;

    SexEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getDescriptionByCode(int code) {
        return Arrays.stream(SexEnum.values())
                .filter(en -> en.getCode() == code)
                .findFirst()
                .map(SexEnum::getDescription)
                .orElse(null);
    }
}
