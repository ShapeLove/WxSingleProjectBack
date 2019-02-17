package com.shape.singleproject.mapping.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.LoginKey;
/**
*  @author author
*/
public interface LoginKeyBaseMapper {

    int insertLoginKey(LoginKey object);

    int updateLoginKey(LoginKey object);

    int update(LoginKey.UpdateBuilder object);

    List<LoginKey> queryLoginKey(LoginKey object);

    LoginKey queryLoginKeyLimit1(LoginKey object);

}