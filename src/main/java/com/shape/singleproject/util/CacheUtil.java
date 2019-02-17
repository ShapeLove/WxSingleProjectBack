package com.shape.singleproject.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.shape.singleproject.SingleProjectApplication;
import com.shape.singleproject.domain.OpenidValue;
import com.shape.singleproject.dto.LoginKey;
import com.shape.singleproject.mapper.OpenidValueMapper;
import com.shape.singleproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class CacheUtil {

    private static LoadingCache<String, OpenidValue> openIdCustomSessionCache;
    private static Cache<String, String> commonCache;
    public final static String USER_NOT_EXIT_PREFIX = "user_not_exist_";
    public final static String CACHE_TRUE_FLAG = "yes";
    public final static String CACHE_FALSE_FLAG = "no";

    static {
        openIdCustomSessionCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .build(CacheLoader.from((key) -> {
                    LoginService loginService = SingleProjectApplication.context.getBean(LoginService.class);
                    LoginKey loginKey = loginService.queryLoginKeyByCustomkey(key);
                    return OpenidValueMapper.INSTANCE.loginKey2OpenidValue(loginKey);
                }));
        commonCache = CacheBuilder.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build();
    }

    public static OpenidValue getOpenIdValue(String key){
        try {
            return openIdCustomSessionCache.get(key);
        } catch (Exception e) {
            return null;
        }
    }

    public static void setOpenIdValue(String key, OpenidValue value) {
        openIdCustomSessionCache.put(key, value);
    }

    public static Set<String> getAllCache() {
        return openIdCustomSessionCache.asMap().keySet();
    }

    public static String get(String key) {
        return commonCache.getIfPresent(key);
    }

    public static void put(String key, String value) {
        commonCache.put(key, value);
    }

}
