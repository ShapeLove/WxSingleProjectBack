package com.shape.singleproject.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.shape.singleproject.dto.AttentionInfo;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.service.AttentionService;
import com.shape.singleproject.service.admin.AdminUserService;
import com.shape.singleproject.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
@Slf4j
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private AttentionService attentionService;

    /**
     * 批量查询用户信息
     * @param adminUserQuery
     * @return
     */
    @PostMapping("/list")
    public PageResult<UserInfo> list(@RequestBody AdminUserQuery adminUserQuery) {
        try {
            return adminUserService.queryUserInfoByPage(adminUserQuery);
        } catch (Exception e) {
            log.error("AdminController.list error adminUserQuery:{}", JSON.toJSONString(adminUserQuery), e);
            return PageResult.build();
        }
    }

    /**
     * 更改用户审核状态
     * @param userInfo
     * @return
     */
    @PostMapping("/updateUserStatus")
    public Result updateUserStatus(@RequestBody UserInfo userInfo) {
        try {
            return adminUserService.updateUserInfoStatus(userInfo);
        } catch (Exception e) {
            log.error("AdminController.updateUserStatus error UserInfo:{}", JSON.toJSONString(userInfo), e);
            return Result.failResultWithDefaultMessage();
        }
    }

    /**
     * 获取当前登录用户数
     * @return
     */
    @RequestMapping("/getOnlineUsers")
    public int getOnlineUsers() {
        try {
            return adminUserService.getAllOnlineUsers().size();
        } catch (Exception e) {
            log.error("AdminController.getOnlineUsers error", e);
            return 0;
        }
    }

    @PostMapping("/attentionList")
    public PageResult<AttentionInfo> attentionList(@RequestBody AttentionQuery attentionQuery) {
        return attentionService.queryAttentionPageByPage(attentionQuery);
    }
}
