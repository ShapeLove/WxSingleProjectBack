package com.shape.singleproject.admin;

import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.service.ExceptService;
import com.shape.singleproject.vo.ExceptPageQuery;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/except")
@Slf4j
public class AdminExceptController {
    @Resource
    public ExceptService exceptService;

    @PostMapping("/pageList")
    public PageResult<ExceptInfo> pageList(@RequestBody ExceptPageQuery exceptPageQuery) {
        return exceptService.queryExceptInfoPage(exceptPageQuery);
    }

    @PostMapping("/deleteExcept")
    public Result deleteExcept(@RequestBody Integer id) {
        exceptService.deleteExceptInfo(id);
        return Result.successResult();
    }
}
