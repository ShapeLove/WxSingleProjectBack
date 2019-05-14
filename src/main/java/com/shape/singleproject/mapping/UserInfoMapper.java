package com.shape.singleproject.mapping;


import com.shape.singleproject.domain.UserInfoRandomQuery;
import com.shape.singleproject.domain.UserInfoScrollQuery;
import org.apache.ibatis.annotations.Mapper;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.mapping.base.UserInfoBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*  @author author
*/
@Repository
@Mapper
public interface UserInfoMapper extends UserInfoBaseMapper{

    int updateUserInfoBasicByOpenId(UserInfo userInfo);

    int updateUserInfoStatusByOpenId(UserInfo userInfo);

    List<UserInfo> selectUserInfoByCreateAndModified(UserInfoScrollQuery userInfoScrollQuery);

    List<UserInfo> queryUserInfoRandom(UserInfoRandomQuery userInfoRandomQuery);
}