package com.shape.singleproject.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.LoginKey;
import com.shape.singleproject.mapping.base.LoginKeyBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
@Mapper
public interface LoginKeyMapper extends LoginKeyBaseMapper{


}