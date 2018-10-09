package com.shape.singleproject.util;

import com.google.common.hash.Hashing;
import com.shape.singleproject.domain.OpenidValue;
import org.apache.commons.codec.Charsets;
import sun.security.provider.MD5;

public class Md5Util {

    private final static String salt = "shapestudio";


    public static String encry(OpenidValue value) {
        final StringBuilder stringBuilder = new StringBuilder(value.getOpenid())
                .append("_")
                .append(value.getSessionKey())
                .append(salt);
        return Hashing.md5()
                .newHasher()
                .putString(stringBuilder.toString(), Charsets.UTF_8)
                .hash()
                .toString();
    }
}
