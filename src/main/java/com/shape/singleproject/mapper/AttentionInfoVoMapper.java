package com.shape.singleproject.mapper;

import com.shape.singleproject.dto.AttentionInfo;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.vo.AttentionInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttentionInfoVoMapper {
    AttentionInfoVoMapper INTANCE = Mappers.getMapper(AttentionInfoVoMapper.class);

    /**
     * 我关注的对象转换
     * 我关注的是需要把关注信息的对方关注openId作为要展示的openId
     * @param info
     * @param userInfo
     * @return
     */
    @Mapping(source = "info.toAttentionOpenid", target = "openId")
    @Mapping(source = "userInfo.name", target = "name")
    @Mapping(source = "userInfo.sex", target = "sex")
    @Mapping(source = "userInfo.photos ", target = "photo")
    AttentionInfoVo info2AttentionVo(AttentionInfo info, UserInfo userInfo);

    /**
     * 谁关注我对象转换
     * 谁关注我对象转换是把关注信息中的发起关注的openId作为要展示的OpenId
     * @param info
     * @param userInfo
     * @return
     */
    @Mapping(source = "info.attentionOpenid", target = "openId")
    @Mapping(source = "userInfo.name", target = "name")
    @Mapping(source = "userInfo.sex", target = "sex")
    @Mapping(source = "userInfo.photos", target = "photo")
    AttentionInfoVo info2SelfAttentionVo(AttentionInfo info, UserInfo userInfo);
}
