package com.shape.singleproject.mapping;


import org.apache.ibatis.annotations.Mapper;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.mapping.base.UserInfoBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
@Mapper
public interface UserInfoMapper extends UserInfoBaseMapper{

    int updateUserInfoBasicByOpenId(UserInfo userInfo);

}