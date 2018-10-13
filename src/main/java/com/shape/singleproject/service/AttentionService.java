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

    /**
     * 处理关注
     * @param attentionInfo
     * @return
     */
    public Result doAttention(AttentionInfo attentionInfo) {
        Result result = new Result();

        if (StringUtils.isEmpty(attentionInfo.getAttentionOpenid())) {
            result.setMessage("关注者id不能为空");
            return result;
        }

        if (StringUtils.isEmpty(attentionInfo.getToAttentionOpenid())) {
            result.setMessage("被关注者id不能为空");
        }

        // 设置操作时间
        attentionInfo.setModified(LocalDateTime.now());

        // 查询是否已经存在的记录
        AttentionInfo existAttentionInfo = queryAttentionByOpenId(attentionInfo.getAttentionOpenid(), attentionInfo.getToAttentionOpenid());

        if (null == existAttentionInfo) {
            // 不存在的话就新加入一个
            attentionInfoMapper.insertAttentionInfo(attentionInfo);
        }else {
            // 如果存在的话就更新
            attentionInfoMapper.update(AttentionInfo.UpdateBuild()
                .set(AttentionInfo.Build()
                    .attentionStatus(attentionInfo.getAttentionStatus())
                    .modified(attentionInfo.getModified())
                    .ext(attentionInfo.getExt())
                    .toAttentionStatus(attentionInfo.getToAttentionStatus())
                    .build())
                .where(AttentionInfo.ConditionBuild()
                    .attentionOpenidList(attentionInfo.getAttentionOpenid())
                    .toAttentionOpenidList(attentionInfo.getToAttentionOpenid()))
                .build());
        }
        result.setSuccess(true);
        return result;
    }

    /**
     * 取消关注
     * @param attentionInfo
     * @return
     */
    public Result doUnAttention(AttentionInfo attentionInfo) {
        Result result = new Result();

        if (StringUtils.isEmpty(attentionInfo.getAttentionOpenid())) {
            result.setMessage("关注者id不能为空");
            return result;
        }

        if (StringUtils.isEmpty(attentionInfo.getToAttentionOpenid())) {
            result.setMessage("被关注者id不能为空");
            return result;
        }

        if (null == attentionInfo.getAttentionStatus() || null == attentionInfo.getToAttentionStatus()) {
            result.setMessage("关注状态不能为空");
            return result;
        }

        // 查询是否已经存在的记录
        AttentionInfo existAttentionInfo = queryAttentionByOpenId(attentionInfo.getAttentionOpenid(), attentionInfo.getToAttentionOpenid());

        if (null == existAttentionInfo) {
            result.setMessage("关注记录不存在，无法取消关注");
            return result;
        }

        if (attentionInfo.getToAttentionStatus().equals(1) && attentionInfo.getAttentionStatus().equals(1)) {
            attentionInfoMapper.delete(attentionInfo);
        }else {
            attentionInfo.setModified(LocalDateTime.now());
            attentionInfoMapper.update(AttentionInfo.UpdateBuild()
                    .set(AttentionInfo.Build()
                            .attentionStatus(attentionInfo.getAttentionStatus())
                            .modified(attentionInfo.getModified())
                            .ext(attentionInfo.getExt())
                            .toAttentionStatus(attentionInfo.getToAttentionStatus())
                            .build())
                    .where(AttentionInfo.ConditionBuild()
                            .attentionOpenidList(attentionInfo.getAttentionOpenid())
                            .toAttentionOpenidList(attentionInfo.getToAttentionOpenid()))
                    .build());
        }
        result.setSuccess(true);
        return result;
    }
}
