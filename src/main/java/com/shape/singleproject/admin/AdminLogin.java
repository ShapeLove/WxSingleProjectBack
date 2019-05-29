package com.shape.singleproject.admin;

import com.shape.singleproject.constant.AdminLevelEnum;
import com.shape.singleproject.dto.AdminUser;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.service.AdminRootService;
import com.shape.singleproject.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/login")
@Slf4j
@LogExceptAop
@TimeAop
public class AdminLogin {

    @Resource
    private AdminRootService adminRootService;

    @PostMapping("/login")
    public Result login(@RequestBody AdminUser adminUser, HttpServletRequest request) {
        Result result = new Result();
        if (StringUtils.isEmpty(adminUser.getName())) {
            result.setMessage("用户名为空！");
            return result;
        }
        if (StringUtils.isEmpty(adminUser.getPasswd())) {
            result.setMessage("密码为空！");
            return result;
        }
        AdminUser temp = adminRootService.queryAdminUserByName(adminUser.getName());
        if (temp != null) {
            if (!temp.getPasswd().equals(adminUser.getPasswd())) {
                return Result.failtResult("用户名密码错误！");
            }
        }else {
            temp = adminRootService.addAdminUser(AdminUser.Build().name(adminUser.getName())
                    .passwd(adminUser.getPasswd())
                    .level(AdminLevelEnum.MANAGER.getLevel())
                    .build());
        }

        request.getSession().setAttribute("adminUser", temp);
        return Result.successResult();
    }

    @GetMapping("/info")
    public AdminUser info(HttpServletRequest request) {
        return (AdminUser)request.getSession().getAttribute("adminUser");
    }
}
