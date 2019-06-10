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

/**
 * 后台管理登录url
 */
@RestController
@RequestMapping("/admin/login")
@Slf4j
@LogExceptAop
@TimeAop
public class AdminLogin {
    /**
     * session中存放登录用户信息的key值
     */
    private final static String userInfoKey = "adminUser";

    /**
     * 后台管理员相关服务
     */
    @Resource
    private AdminRootService adminRootService;

    /**
     * 登录url
     * @param adminUser 只需要传用户名和密码
     * @param request 用于操作session
     * @return 会返回是否成功
     */
    @PostMapping("/login")
    public Result login(@RequestBody AdminUser adminUser, HttpServletRequest request) {
        Result result = new Result();

        // 1.校验用户名和密码是否为空
        if (StringUtils.isEmpty(adminUser.getName())) {
            result.setMessage("用户名为空！");
            return result;
        }
        if (StringUtils.isEmpty(adminUser.getPasswd())) {
            result.setMessage("密码为空！");
            return result;
        }

        // 2.根据用户名查询是否存在该用户
        AdminUser temp = adminRootService.queryAdminUserByName(adminUser.getName());
        if (temp != null) {

            // 3.如果存在但是密码不匹配的话返回错误信息给前端
            if (!temp.getPasswd().equals(adminUser.getPasswd())) {
                return Result.failtResult("用户名密码错误！");
            }
        }else {

            // 4.如果没有就创建一个管理员
            temp = adminRootService.addAdminUser(AdminUser.Build().name(adminUser.getName())
                    .passwd(adminUser.getPasswd())
                    .level(AdminLevelEnum.MANAGER.getLevel())
                    .build());
        }

        // 5.把该用户信息放到session中保存
        request.getSession().setAttribute(userInfoKey, temp);
        return Result.successResult();
    }

    /**
     * 用于后台管理前端获取当前登录的管理员信息
     * @param request 从session中取值
     * @return
     */
    @GetMapping("/info")
    public AdminUser info(HttpServletRequest request) {
        return (AdminUser)request.getSession().getAttribute(userInfoKey);
    }

    /**
     * 退出登录
     * @param request 从session中删除登录用户信息
     * @return
     */
    @GetMapping("/loginOut")
    public boolean loginOut(HttpServletRequest request) {
        try {
            request.getSession().removeAttribute(userInfoKey);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
