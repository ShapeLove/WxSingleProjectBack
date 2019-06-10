package com.shape.singleproject.admin;

import com.shape.singleproject.dto.Report;
import com.shape.singleproject.service.ReportService;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.ReportPageQuery;
import com.shape.singleproject.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台管理-举报管理
 */
@RestController
@RequestMapping("/admin/report")
@Slf4j
public class AdminReportController {

    /**
     * 举报相关服务
     */
    @Resource
    private ReportService reportService;

    /**
     * 分页查询举报信息
     * @param reportPageQuery 分页参数和查询参数
     * @return
     */
    @PostMapping("/pageList")
    public PageResult<Report> pageList(@RequestBody ReportPageQuery reportPageQuery) {
        return reportService.queryReportsByPage(reportPageQuery);
    }

    /**
     * 处理举报
     * 通过和驳回
     * @param report 只需要传id和status即可
     * @return
     */
    @PostMapping("/handleReport")
    public Result handleReport(@RequestBody Report report) {
        reportService.handleReport(report.getId(), report.getStatus());
        return Result.successResult();
    }

    /**
     * 删除举报信息
     * 主要用于删除被驳回和通过的举报信息
     * @param report
     * @return
     */
    @PostMapping("/deleteReport")
    public Result deleteReport(@RequestBody Report report) {
        reportService.deleteReport(report.getId());
        return Result.successResult();
    }
}

