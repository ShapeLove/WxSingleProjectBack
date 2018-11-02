package com.shape.singleproject.constant;

/**
 * 星座枚举
 */
public enum ConstellationEnum {

    BAIYANG(0, "白羊座"),
    JINNIU(1, "金牛座"),
    SHUANGZI(2, "双子座"),
    JUXIE(3, "巨蟹座"),
    SHIZI(4, "狮子座"),
    CHUNV(5, "处女座"),
    TIANCHENG(6, "天秤座"),
    TIANXIE(7, "天蝎座"),
    SHESHOU(8, "射手座"),
    MOXIE(9, "魔蝎座"),
    SHUIPING(10, "水瓶座"),
    SHUANGYU(11, "双鱼座");

    private int code;
    private String description;

    ConstellationEnum(int code,String description) {
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

    public static ConstellationEnum getValueByCode(Integer code) {
        for (ConstellationEnum constellationEnum : ConstellationEnum.values()) {
            if (code.equals(constellationEnum.code)) {
                return constellationEnum;
            }
        }
        return null;
    }

}
