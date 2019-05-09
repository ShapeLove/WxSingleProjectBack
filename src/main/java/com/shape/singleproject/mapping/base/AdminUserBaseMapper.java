package com.shape.singleproject.mapping.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.AdminUser;
/**
*  @author author
*/
public interface AdminUserBaseMapper {

    int insertAdminUser(AdminUser object);

    int updateAdminUser(AdminUser object);

    int update(AdminUser.UpdateBuilder object);

    List<AdminUser> queryAdminUser(AdminUser object);

    AdminUser queryAdminUserLimit1(AdminUser object);

}