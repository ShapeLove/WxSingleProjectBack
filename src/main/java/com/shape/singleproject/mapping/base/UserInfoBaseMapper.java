package com.shape.singleproject.mapping.base;

import java.util.List;
import com.shape.singleproject.dto.UserInfo;
/**
*  @author author
*/
public interface UserInfoBaseMapper {

    int insertUserInfo(UserInfo object);

    int updateUserInfo(UserInfo object);

    int update(UserInfo.UpdateBuilder object);

    List<UserInfo> queryUserInfo(UserInfo object);

    UserInfo queryUserInfoLimit1(UserInfo object);

    List<UserInfo> queryUserInfoDesc(UserInfo object);

}