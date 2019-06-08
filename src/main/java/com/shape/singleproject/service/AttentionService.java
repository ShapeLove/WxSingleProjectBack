package com.shape.singleproject.service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.shape.singleproject.dto.AttentionInfo;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapper.AttentionInfoVoMapper;
import com.shape.singleproject.mapping.AttentionInfoMapper;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.vo.AttentionInfoVo;
import com.shape.singleproject.vo.AttentionQuery;
import com.shape.singleproject.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
@LogExceptAop
@TimeAop
public class AttentionService {

    @Resource
    private AttentionInfoMapper attentionInfoMapper;

    @Resource
    private UserInfoMapper userInfoMapper;


    /**
     * 批量获取关注信息
     * @param attentionQuery
     * @return
     */
    public List<AttentionInfoVo> queryAttentionByPage(AttentionQuery attentionQuery) {

        PageHelper.startPage(attentionQuery.getPageIndex(), attentionQuery.getPageSize());
        AttentionInfo.QueryBuilder queryBuilder = AttentionInfo.QueryBuild();

        if (Optional.ofNullable(attentionQuery)
            .map(AttentionQuery::getAttentionOpenId).isPresent()) {
            queryBuilder.attentionOpenid(attentionQuery.getAttentionOpenId());
        }

        if (Optional.ofNullable(attentionQuery)
            .map(AttentionQuery::getToAttentionOpenId).isPresent()) {
            queryBuilder.toAttentionOpenid(attentionQuery.getToAttentionOpenId());
        }

        List<AttentionInfo> attentionInfos = attentionInfoMapper.queryAttentionInfo(queryBuilder.build());

        PageInfo<AttentionInfo> pageInfo = new PageInfo(attentionInfos);

        return Optional.ofNullable(pageInfo.getList())
                .filter(list -> !CollectionUtils.isEmpty(list))
                .map(attentionList -> attentionList.stream()
                        .map(item -> {
                            String openId = "";
                            UserInfo userInfo = new UserInfo();
                            if (!StringUtils.isEmpty(attentionQuery.getAttentionOpenId())) {
                               openId = item.getToAttentionOpenid();
                            }else if(!StringUtils.isEmpty(attentionQuery.getToAttentionOpenId())) {
                                openId = item.getAttentionOpenid();
                            }

                            if (!StringUtils.isEmpty(openId)) {
                                userInfo = userInfoMapper.queryUserInfoLimit1(UserInfo.QueryBuild()
                                        .fetchPhotos()
                                        .fetchName()
                                        .fetchSex()
                                        .openId(openId).build());
                            }

                            if (!StringUtils.isEmpty(userInfo.getPhotos())) {
                                userInfo.setPhotos(JSONArray.parseArray(userInfo.getPhotos(), String.class).get(0));
                            }

                            if (!StringUtils.isEmpty(attentionQuery.getAttentionOpenId())) {
                                // 查询的是我关注的
                                return AttentionInfoVoMapper.INTANCE.info2AttentionVo(item, userInfo);
                            }else if(!StringUtils.isEmpty(attentionQuery.getToAttentionOpenId())) {
                                // 查询谁关注我
                                return AttentionInfoVoMapper.INTANCE.info2SelfAttentionVo(item, userInfo);
                            }else {
                                return null;
                            }
                        }).collect(Collectors.toList())
                )
                .orElse(Lists.newArrayList());
    }

    /**
     * 批量获取关注信息
     * @param attentionQuery
     * @return
     */
    public PageResult<AttentionInfo> queryAttentionPageByPage(AttentionQuery attentionQuery) {

        PageHelper.startPage(attentionQuery.getPageIndex(), attentionQuery.getPageSize());
        AttentionInfo.QueryBuilder queryBuilder = AttentionInfo.QueryBuild();

        if (Optional.ofNullable(attentionQuery)
                .map(AttentionQuery::getAttentionOpenId).isPresent()) {
            queryBuilder.attentionOpenid(attentionQuery.getAttentionOpenId());
        }

        if (Optional.ofNullable(attentionQuery)
                .map(AttentionQuery::getToAttentionOpenId).isPresent()) {
            queryBuilder.toAttentionOpenid(attentionQuery.getToAttentionOpenId());
        }

        List<AttentionInfo> attentionInfos = attentionInfoMapper.queryAttentionInfo(queryBuilder.build());

        PageInfo<AttentionInfo> pageInfo = new PageInfo(attentionInfos);

        return PageResult.build()
                .setDataList(pageInfo.getList())
                .setTotalPage(pageInfo.getPages())
                .setTotalCount(pageInfo.getTotal())
                .setSuccess(true);
    }

    /**
     * 根据关注者Id和被关注者Id查唯一记录
     * @param attentionOpenId
     * @param toAttentionOpenId
     * @return
     */
    public AttentionInfo queryAttentionByOpenId(String attentionOpenId, String toAttentionOpenId) {

        if (StringUtils.isEmpty(attentionOpenId) || StringUtils.isEmpty(toAttentionOpenId)) {
            return null;
        }

        return attentionInfoMapper.queryAttentionInfoLimit1(AttentionInfo.QueryBuild()
            .attentionOpenid(attentionOpenId)
            .toAttentionOpenid(toAttentionOpenId)
            .build());
    }
}
