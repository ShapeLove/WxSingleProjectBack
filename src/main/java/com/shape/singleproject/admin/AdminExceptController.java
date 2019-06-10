package com.shape.singleproject.admin;

import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.service.ExceptService;
import com.shape.singleproject.vo.ExceptPageQuery;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台管理-异常信息管理
 */
@RestController
@RequestMapping("/admin/except")
@Slf4j
public class AdminExceptController {
    /**
     * 异常信息服务
     */
    @Resource
    public ExceptService exceptService;

    /**
     * 分页查询异常信息
     * @param exceptPageQuery 第几页、一页显示多少条数据、查询参数等
     * @return
     */
    @PostMapping("/pageList")
    public PageResult<ExceptInfo> pageList(@RequestBody ExceptPageQuery exceptPageQuery) {
        return exceptService.queryExceptInfoPage(exceptPageQuery);
    }

    /**
     * 删除该异常信息
     * @param exceptInfo
     * @return
     */
    @PostMapping("/deleteExcept")
    public Result deleteExcept(@RequestBody ExceptInfo exceptInfo) {
        exceptService.deleteExceptInfo(exceptInfo.getId());
        return Result.successResult();
    }
}
