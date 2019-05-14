package com.shape.singleproject.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.AdminUser;
import com.shape.singleproject.mapping.base.AdminUserBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
@Mapper
public interface AdminUserMapper extends AdminUserBaseMapper{

    int deleteAdminUser(Integer adminUserId);
}