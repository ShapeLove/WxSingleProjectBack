package com.shape.singleproject.constant;

import java.util.Arrays;

/**
 * 标签类型
 */
public enum TagTypeEnum {
    DOING(0, "正在.."),
    PLAN(1, "打算.."),
    ACTIVITY(2, "活动是..");

    private Integer tagCode;
    private String tagDesc;

    TagTypeEnum(Integer tagCode, String tagDesc) {
        this.tagCode = tagCode;
        this.tagDesc = tagDesc;
    }

    public Integer getTagCode() {
        return tagCode;
    }

    public void setTagCode(Integer tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    public String getDescByCode(Integer code) {
        return Arrays.stream(TagTypeEnum.values())
                .filter(en -> en.getTagCode().equals(code))
                .findFirst()
                .map(TagTypeEnum::getTagDesc)
                .orElse(null);
    }
}
