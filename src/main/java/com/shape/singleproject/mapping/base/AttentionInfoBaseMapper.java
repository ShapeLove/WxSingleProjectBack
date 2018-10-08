package com.shape.singleproject.mapping.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.AttentionInfo;
/**
*  @author author
*/
public interface AttentionInfoBaseMapper {

    int insertAttentionInfo(AttentionInfo object);

    int updateAttentionInfo(AttentionInfo object);

    int update(AttentionInfo.UpdateBuilder object);

    List<AttentionInfo> queryAttentionInfo(AttentionInfo object);

    AttentionInfo queryAttentionInfoLimit1(AttentionInfo object);

}