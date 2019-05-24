package com.shape.singleproject.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.mapping.base.ExceptInfoBaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
@Mapper
public interface ExceptInfoMapper extends ExceptInfoBaseMapper{

    int deleteExceptInfo(Long id);
}