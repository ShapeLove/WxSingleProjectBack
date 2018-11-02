package com.shape.singleproject.constant;

/**
 * 学历枚举
 */
public enum EducationEnum {
    DAZHUAN(0, "大专"),
    BENKE(1, "本科"),
    SHUOSHI(2, "硕士"),
    BOSHI(3, "博士");

    private int code;
    private String description;

    EducationEnum(int code, String description) {
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

    public static EducationEnum getValueByCode(Integer code) {
        for (EducationEnum educationEnum : EducationEnum.values()) {
            if (code.equals(educationEnum.code)) {
                return educationEnum;
            }
        }
        return null;
    }
}
