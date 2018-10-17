package com.shape.singleproject.constant;

/**
 * 用户审核状态枚举
 */
public enum UserStatusEnum {
    GUEST(-1, "游客"),
    WAIT(0, "待审核"),
    SUCCESS(1, "审核通过"),
    FAIL(2, "驳回");

    private int status;
    private String description;

    UserStatusEnum(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
