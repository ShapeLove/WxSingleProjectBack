package com.shape.singleproject.mapper;

import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.vo.UserInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomUserInfoMapper {
    CustomUserInfoMapper INSTANCE = Mappers.getMapper(CustomUserInfoMapper.class);

    UserInfoVo info2Vo(UserInfo userInfo);
}
