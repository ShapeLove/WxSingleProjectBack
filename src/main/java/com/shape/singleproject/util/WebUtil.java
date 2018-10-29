package com.shape.singleproject.util;

import com.shape.singleproject.domain.OpenidValue;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class WebUtil {

    public static OpenidValue getCurrentUserOpenidValue() {
        ServletRequestAttributes  servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String sessionKey = request.getHeader("sessionId");
        System.out.println("WebUtil getCurrentUserOpenidValue sessionKey:" + sessionKey);
        if (StringUtils.isEmpty(sessionKey)) {
            return null;
        }else {
            return CacheUtil.getOpenIdValue(sessionKey);
        }
    }

    public static String getCurrentUserOpenId() {
        return Optional.ofNullable(getCurrentUserOpenidValue())
                .map(OpenidValue::getOpenid)
                .orElse(null);
    }
}
