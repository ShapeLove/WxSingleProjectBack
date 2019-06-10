package com.shape.singleproject.admin;


import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.AdminUser;
import com.shape.singleproject.service.AdminRootService;
import com.shape.singleproject.vo.AdminUserPageQuery;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台管理-管理员信息管理url
 */
@RestController
@RequestMapping("/admin/manager")
@Slf4j
public class AdminManageController {
    @Resource
    private AdminRootService adminRootService;

    /**
     * 分页查询管理员信息
     * @param adminUserPageQuery
     * @return
     */
    @PostMapping("/pageList")
    public PageResult<AdminUser> pageList(@RequestBody AdminUserPageQuery adminUserPageQuery) {
        return adminRootService.queryAdminUserByPage(adminUserPageQuery);
    }

    /**
     * 更新管理员信息
     * 打算重置密码或者提升管理员级别使用（目前未使用）
     * @param adminUser
     * @return
     */
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

    /**
     * 目前未使用
     * 新增管理员都是注册的
     * @param adminUser
     * @return
     */
    @PostMapping("/addManager")
    public Result addManager(@RequestBody AdminUser adminUser) {
        try {
            adminRootService.addAdminUser(adminUser);
        } catch (DuplicateKeyException e) {
            return Result.failtResult("该用户: " + adminUser.getName() +"信息已存在");
        }catch (Exception e) {
            return Result.failResultWithDefaultMessage();
        }
        return Result.successResult();
    }

    /**
     * 删除管理员信息
     * 目前未使用
     * @param adminUser 只需要传id即可
     * @return
     */
    @PostMapping("/deleteManager")
    public Result deleteManager(@RequestBody AdminUser adminUser) {
        adminRootService.deleteAdminUser(adminUser.getId());
        return Result.successResult();
    }
}
