package com.shape.singleproject.filter;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.domain.OpenidValue;
import com.shape.singleproject.util.CacheUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆拦截器
 */
public class LoginFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String sessionId = request.getHeader("sessionId");
        boolean flag = true;
        if (StringUtils.isEmpty(sessionId)) {
            flag = false;
        }else {
            OpenidValue openidValue = CacheUtil.getOpenIdValue(sessionId);
            if (null == openidValue) {
                flag = false;
            }
            System.out.println(JSON.toJSONString(openidValue));
        }

        if (!flag) {
            // 没有登录
            String origin = request.getHeader("Origin");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setHeader("Access-Control-Allow-Headers","Origin,Content-Type,Accept,token,X-Requested-With");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.getWriter().write("notlogin");
            response.getWriter().flush();
            return false;
        }

        return true;
    }
}
