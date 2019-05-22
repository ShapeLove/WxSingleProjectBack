package com.shape.singleproject.admin;

import com.shape.singleproject.dto.Report;
import com.shape.singleproject.service.ReportService;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.ReportPageQuery;
import com.shape.singleproject.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/report")
@Slf4j
public class AdminReportController {

    @Resource
    private ReportService reportService;


    @PostMapping("/pageList")
    public PageResult<Report> pageList(@RequestBody ReportPageQuery reportPageQuery) {
        return reportService.queryReportsByPage(reportPageQuery);
    }

    @PostMapping("/handleReport")
    public Result handleReport(@RequestBody Report report) {
        reportService.handleReport(report.getId(), report.getStatus());
        return Result.successResult();
    }

    @PostMapping("/addReport")
    public Result addReport(@RequestBody Report report) {
        reportService.addReport(report);
        return Result.successResult();
    }

    @PostMapping("/deleteReport")
    public Result deleteReport(@RequestBody Report report) {
        reportService.deleteReport(report.getId());
        return Result.successResult();
    }
}

