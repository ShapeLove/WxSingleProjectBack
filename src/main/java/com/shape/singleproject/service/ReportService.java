package com.shape.singleproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shape.singleproject.dto.Report;
import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.ReportMapper;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.ReportPageQuery;
import com.shape.singleproject.vo.TagPageQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 举报处理Service
 */
@Service
@LogExceptAop
@TimeAop
public class ReportService {

    @Resource
    private ReportMapper reportMapper;

    /**
     * 举报分页查询
     * @param reportPageQuery
     * @return
     */
    public PageResult<Report> queryReportsByPage(ReportPageQuery reportPageQuery) {
        PageHelper.startPage(reportPageQuery.getPageIndex(), reportPageQuery.getPageSize());
        Report.QueryBuilder queryBuilder = Report.QueryBuild();
        queryBuilder.fetchAll();
        if (!StringUtils.isEmpty(reportPageQuery.getOpenId())) {
            queryBuilder.openId(reportPageQuery.getOpenId());
        }
        if (!StringUtils.isEmpty(reportPageQuery.getReportOpenId())) {
            queryBuilder.reportOpenId(reportPageQuery.getReportOpenId());
        }
        if (null != reportPageQuery.getStatus()) {
            queryBuilder.status(reportPageQuery.getStatus());
        }

        List<Report> reportList = reportMapper.queryReport(queryBuilder.build());
        PageInfo pageInfo = new PageInfo(reportList);
        return PageResult.build()
                .setDataList(pageInfo.getList())
                .setTotalPage(pageInfo.getPages())
                .setTotalCount(pageInfo.getTotal())
                .setSuccess(true);
    }

    /**
     * 增加举报
     * @param report
     */
    public void addReport(Report report) {
        reportMapper.insertReport(report);
    }

    /**
     * 处理举报
     * @param reportId
     * @param status
     */
    public void handleReport(Integer reportId, Integer status) {
        reportMapper.update(Report.UpdateBuild()
                .set(Report.Build().status(status).build())
                .where(Report.ConditionBuild().idList(reportId))
                .build()
        );
    }

    /**
     * 删除举报
     * @param reportId
     */
    public void deleteReport(Integer reportId) {
        reportMapper.deleteReport(reportId);
    }
}
