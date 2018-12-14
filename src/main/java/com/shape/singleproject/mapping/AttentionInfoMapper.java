package com.shape.singleproject.mapping;


import org.apache.ibatis.annotations.Mapper;
import com.shape.singleproject.dto.AttentionInfo;
import com.shape.singleproject.mapping.base.AttentionInfoBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
@Mapper
public interface AttentionInfoMapper extends AttentionInfoBaseMapper{

    int delete(AttentionInfo attentionInfo);
}