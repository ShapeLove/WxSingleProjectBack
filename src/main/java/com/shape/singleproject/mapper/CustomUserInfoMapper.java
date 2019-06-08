package com.shape.singleproject.mapper;

import com.shape.singleproject.dto.AttentionInfo;
import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.mapping.AttentionInfoMapper;
import com.shape.singleproject.mapping.TagsMapper;
import com.shape.singleproject.util.ApplicationContextUtil;
import com.shape.singleproject.vo.UserInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface CustomUserInfoMapper {
    CustomUserInfoMapper INSTANCE = Mappers.getMapper(CustomUserInfoMapper.class);

    AttentionInfoMapper attentionInfoMapper = ApplicationContextUtil.getTargetBeanByType(AttentionInfoMapper.class);

    TagsMapper tagsMapper = ApplicationContextUtil.getTargetBeanByType(TagsMapper.class);

    @Mapping(target= "constellationStr", expression = "java( com.shape.singleproject.constant.ConstellationEnum.getDescByCode( userInfo.getConstellation()) )")
    @Mapping(target = "educationStr", expression = "java( com.shape.singleproject.constant.EducationEnum.getDescByCode( userInfo.getEducation()) )")
    @Mapping(target = "photoList", expression = "java( com.alibaba.fastjson.JSONArray.parseArray( userInfo.getPhotos(), String.class) )")
    UserInfoVo info2Vo(UserInfo userInfo);

    /**
     * userInfo转换类
     * 带有是否关注信息和标签信息
     * @param userInfo
     * @param currentOpenId
     * @return
     */
    default UserInfoVo info2VoWithAttentionAndTag(UserInfo userInfo, String currentOpenId) {
        UserInfoVo userInfoVo = info2Vo(userInfo);
        if (userInfo == null) {
            return null;
        }
        AttentionInfo attentionInfo = attentionInfoMapper.queryAttentionInfoLimit1(
                AttentionInfo.QueryBuild()
                        .toAttentionOpenid(userInfo.getOpenId())
                        .attentionOpenid(currentOpenId)
                        .build()
        );

        if (null != attentionInfo) {
            userInfoVo.setAttention(true);
            AttentionInfo selfAttentionInfo = attentionInfoMapper.queryAttentionInfoLimit1(
                    AttentionInfo.QueryBuild()
                            .toAttentionOpenid(currentOpenId)
                            .attentionOpenid(userInfo.getOpenId())
                            .build());
            if (null != selfAttentionInfo) {
                userInfoVo.setAllAttention(true);
            }
        }

        if (null != userInfo.getDoingTags()) {
            userInfoVo.setDoingTagsDesc(Optional.ofNullable(tagsMapper.queryTagsLimit1(Tags.QueryBuild().fetchTagName()
             .id(userInfo.getDoingTags()).build()))
                    .map(Tags::getTagName)
                    .filter(StringUtils::isNotBlank)
                    .orElse(null));
        }
        if (null != userInfo.getPlanTags()) {
            userInfoVo.setPlanTagsDesc(Optional.ofNullable(tagsMapper.queryTagsLimit1(Tags.QueryBuild().fetchTagName()
                    .id(userInfo.getPlanTags()).build()))
                    .map(Tags::getTagName)
                    .filter(StringUtils::isNotBlank)
                    .orElse(null));
        }
        if (null != userInfo.getActivityTags()) {
            userInfoVo.setActivityTagsDesc(Optional.ofNullable(tagsMapper.queryTagsLimit1(Tags.QueryBuild().fetchTagName()
                    .id(userInfo.getActivityTags()).build()))
                    .map(Tags::getTagName)
                    .filter(StringUtils::isNotBlank)
                    .orElse(null));
        }
        return userInfoVo;
    }

    /**
     * 转换类只带有标签信息
     * @param userInfo
     * @return
     */
    default UserInfoVo info2VoWithTag(UserInfo userInfo) {
        UserInfoVo userInfoVo = info2Vo(userInfo);
        if (userInfo == null) {
            return null;
        }
        if (null != userInfo.getDoingTags()) {
            userInfoVo.setDoingTagsDesc(Optional.ofNullable(tagsMapper.queryTagsLimit1(Tags.QueryBuild().fetchTagName()
                    .id(userInfo.getDoingTags()).build()))
                    .map(Tags::getTagName)
                    .filter(StringUtils::isNotBlank)
                    .orElse(null));
        }
        if (null != userInfo.getPlanTags()) {
            userInfoVo.setPlanTagsDesc(Optional.ofNullable(tagsMapper.queryTagsLimit1(Tags.QueryBuild().fetchTagName()
                    .id(userInfo.getPlanTags()).build()))
                    .map(Tags::getTagName)
                    .filter(StringUtils::isNotBlank)
                    .orElse(null));
        }
        if (null != userInfo.getActivityTags()) {
            userInfoVo.setActivityTagsDesc(Optional.ofNullable(tagsMapper.queryTagsLimit1(Tags.QueryBuild().fetchTagName()
                    .id(userInfo.getActivityTags()).build()))
                    .map(Tags::getTagName)
                    .filter(StringUtils::isNotBlank)
                    .orElse(null));
        }
        return userInfoVo;
    }
}
