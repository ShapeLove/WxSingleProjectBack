package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.shape.singleproject.dto.*;
import com.shape.singleproject.vo.*;

public class Test {

    public static void main(String[] args) {
        one();
        result();
    }

    public static void one() {
        System.out.println(JSON.toJSONString(new AttentionQuery(), SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty));
    }

    public static void result() {
        PageResult pageResult = PageResult.build()
                .setDataList(Lists.newArrayList(new AttentionInfo()));
        System.out.println(JSON.toJSONString(pageResult, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty));
    }
}
