package com.shape.singleproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shape.singleproject.dto.AttentionInfo;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.AttentionInfoMapper;
import com.shape.singleproject.vo.AttentionQuery;
import com.shape.singleproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@LogExceptAop
@TimeAop
public class AttentionService {

    @Autowired
    private AttentionInfoMapper attentionInfoMapper;


    /**
     * 批量获取关注信息
     * @param attentionQuery
     * @return
     */
    public List<AttentionInfo> queryAttentionByPage(AttentionQuery attentionQuery) {

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

        PageInfo pageInfo = new PageInfo(attentionInfos);

        return pageInfo.getList();
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
