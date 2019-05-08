package com.shape.singleproject.admin;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.service.AdminService;
import com.shape.singleproject.vo.AdminUserQuery;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 批量查询用户信息
     * @param adminUserQuery
     * @return
     */
    @RequestMapping("/list")
    public PageResult<UserInfo> list(@RequestBody AdminUserQuery adminUserQuery) {
        try {
            return adminService.queryUserInfoByPage(adminUserQuery);
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
    @RequestMapping("/updateUserStatus")
    public Result updateUserStatus(@RequestBody UserInfo userInfo) {
        try {
            return adminService.updateUserInfoStatus(userInfo);
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
            return adminService.getAllOnlineUsers().size();
        } catch (Exception e) {
            log.error("AdminController.getOnlineUsers error", e);
            return 0;
        }
    }
}
