package com.shape.singleproject.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.shape.singleproject.domain.OpenidValue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CacheUtil {

    private static Cache<String, OpenidValue> openIdCustomSessionCache;


    static {
        openIdCustomSessionCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(2, TimeUnit.HOURS)
                .build();
    }

    public static OpenidValue getOpenIdValue(String key) {
        return openIdCustomSessionCache.getIfPresent(key);
    }

    public static void setOpenIdValue(String key, OpenidValue value) {
        openIdCustomSessionCache.put(key, value);
    }

    public static Set<String> getAllCache() {
        return openIdCustomSessionCache.asMap().keySet();
    }
}
