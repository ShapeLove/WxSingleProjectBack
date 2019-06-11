package com.shape.singleproject.constant;

/**
 * 全局静态变量类
 */
public class AppConst {

    // 不允许实例化
    private AppConst() {
        throw new IllegalStateException("Utility class");
    }

    public static final Integer ATENTION = 0;
    public static final Integer NO_ATENTION = 1;
}
