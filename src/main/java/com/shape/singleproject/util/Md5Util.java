package com.shape.singleproject.util;

import com.google.common.hash.Hashing;
import com.shape.singleproject.domain.OpenidValue;
import org.apache.commons.codec.Charsets;

public class Md5Util {

    private final static String SALT = "shapestudio";


    public static String encry(OpenidValue value) {
        final StringBuilder stringBuilder = new StringBuilder(value.getOpenid())
                .append("_")
                .append(value.getSessionKey())
                .append(SALT);
        return Hashing.md5()
                .newHasher()
                .putString(stringBuilder.toString(), Charsets.UTF_8)
                .hash()
                .toString();
    }
    public static String encry(String openId, String sessionKey) {
        final StringBuilder stringBuilder = new StringBuilder(openId)
                .append("_")
                .append(sessionKey)
                .append(SALT);
        return Hashing.md5()
                .newHasher()
                .putString(stringBuilder.toString(), Charsets.UTF_8)
                .hash()
                .toString();
    }
}
