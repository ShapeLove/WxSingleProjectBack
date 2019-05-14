package com.shape.singleproject.constant;

/**
 * 举报类型
 */
public enum ReportType {
    ;
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
