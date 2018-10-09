package com.shape.singleproject.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.shape.singleproject.domain.OpenidValue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class CacheUtil {

    private static LoadingCache<String, OpenidValue> openIdCustomSessionCache;

    @PostConstruct
    public void initCache() {
        openIdCustomSessionCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(2, TimeUnit.HOURS)
                .build(
                        new CacheLoader<String, OpenidValue>() {
                            @Override
                            public OpenidValue load(String s) throws Exception {
                                return null;
                            }
                        }
                );
    }

    public static OpenidValue getOpenIdValue(String key) {
        return openIdCustomSessionCache.getUnchecked(key);
    }

    public static void setOpenIdValue(String key, OpenidValue value) {
        openIdCustomSessionCache.put(key, value);
    }
}
