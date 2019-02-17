package com.shape.singleproject.mapper;

import com.shape.singleproject.domain.OpenidValue;
import com.shape.singleproject.dto.LoginKey;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.vo.UserInfoVo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sun.rmi.runtime.Log;

@Mapper
public interface OpenidValueMapper {
    OpenidValueMapper INSTANCE = Mappers.getMapper(OpenidValueMapper.class);

    OpenidValue loginKey2OpenidValue(LoginKey loginKey);

    @InheritInverseConfiguration
    LoginKey openidValue2LoginKey(OpenidValue openidValue);
}
