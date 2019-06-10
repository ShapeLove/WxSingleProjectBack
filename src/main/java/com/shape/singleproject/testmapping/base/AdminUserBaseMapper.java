package com.shape.singleproject.testmapping.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.testdto.AdminUser;
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