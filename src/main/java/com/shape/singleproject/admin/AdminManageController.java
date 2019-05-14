package com.shape.singleproject.admin;


import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.AdminUser;
import com.shape.singleproject.service.AdminRootService;
import com.shape.singleproject.vo.AdminUserPageQuery;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/manager")
@Slf4j
public class AdminManageController {
    @Resource
    private AdminRootService adminRootService;

    @PostMapping("/pageList")
    public PageResult<AdminUser> pageList(@RequestBody AdminUserPageQuery adminUserPageQuery) {
        return adminRootService.queryAdminUserByPage(adminUserPageQuery);
    }

    @PostMapping("/updateManager")
    public Result updateManager(@RequestBody AdminUser adminUser) {
        try {
            adminRootService.modifiedAdminUser(adminUser);
            return Result.successResult();
        } catch (Exception e) {
            log.error("AdminManageController.updateManager error adminUser:{}", JSON.toJSONString(adminUser), e);
            return Result.failResultWithDefaultMessage();
        }
    }

    @PostMapping("/addManager")
    public Result addManager(@RequestBody AdminUser adminUser) {
        adminRootService.addAdminUser(adminUser);
        return Result.successResult();
    }

    @PostMapping("/deleteManager")
    public Result addManager(@RequestBody Integer id) {
        adminRootService.deleteAdminUser(id);
        return Result.successResult();
    }
}
