package com.shape.singleproject.constant;

import java.util.Arrays;

public enum AdminLevelEnum {
    MANAGER(0, "管理员"),
    DEVELOP(1, "开发管理员"),
    SUPER(2, "超级管理员");
    private Integer level;
    private String desc;

    AdminLevelEnum(Integer level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getAdminLevelDescByLevel(Integer level) {
        return Arrays.stream(AdminLevelEnum.values())
                .filter(en -> en.getLevel().equals(level))
                .findFirst()
                .map(AdminLevelEnum::getDesc)
                .orElse(null);
    }
}
