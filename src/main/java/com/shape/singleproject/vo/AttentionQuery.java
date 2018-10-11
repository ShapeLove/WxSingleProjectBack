package com.shape.singleproject.vo;

import lombok.Data;

@Data
public class AttentionQuery extends BaseQuery {
    /**
     * 发起关注者openId
     */
    private String attentionOpenId;
    /**
     * 被发起关注者openId
     */
    private String toAttentionOpenId;
}
