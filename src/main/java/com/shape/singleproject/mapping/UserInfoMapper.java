package com.shape.singleproject.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.mapping.base.UserInfoBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
@Mapper
public interface UserInfoMapper extends UserInfoBaseMapper{


}