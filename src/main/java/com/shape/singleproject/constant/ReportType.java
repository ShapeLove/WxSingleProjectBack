package com.shape.singleproject.constant;

/**
 * 举报类型
 */
public enum ReportType {
    SEX(1, "照片涉黄"),
    HARASSMENT(2, "恶意骚扰"),
    STEALING(3, "盗用图片"),
    OTHER(4, "其他");
    /**
     * 举报类型Code
     */
    private Integer reportCode;
    /**
     * 描述
     */
    private String desc;

    ReportType(Integer reportCode, String desc) {
        this.reportCode = reportCode;
        this.desc = desc;
    }

    public Integer getReportCode() {
        return reportCode;
    }

    public void setReportCode(Integer reportCode) {
        this.reportCode = reportCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
