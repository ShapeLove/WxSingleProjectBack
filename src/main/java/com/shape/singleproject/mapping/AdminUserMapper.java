package com.shape.singleproject.mapping;

import java.util.List;

import com.shape.singleproject.domain.DateCountQuery;
import com.shape.singleproject.dto.DateCountDo;
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

    List<DateCountDo> analysisAdminUserCountByDate(DateCountQuery dateCountQuery);

    Long queryAllAdminUserCount();
}