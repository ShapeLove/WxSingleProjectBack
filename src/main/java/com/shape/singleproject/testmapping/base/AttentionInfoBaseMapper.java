package com.shape.singleproject.testmapping.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.testdto.AttentionInfo;
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