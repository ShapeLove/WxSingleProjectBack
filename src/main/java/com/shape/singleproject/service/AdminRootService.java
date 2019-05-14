package com.shape.singleproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shape.singleproject.dto.AdminUser;
import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.AdminUserMapper;
import com.shape.singleproject.vo.AdminUserPageQuery;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.TagPageQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@LogExceptAop
@TimeAop
public class AdminRootService {

    @Resource
    private AdminUserMapper adminUserMapper;

    /**
     * 管理员信息分页查询
     * @param adminUserPageQuery
     * @return
     */
    public PageResult<AdminUser> queryAdminUserByPage(AdminUserPageQuery adminUserPageQuery) {
        PageHelper.startPage(adminUserPageQuery.getPageIndex(), adminUserPageQuery.getPageSize());
        AdminUser.QueryBuilder queryBuilder = AdminUser.QueryBuild();
        queryBuilder.fetchAll();
        if (!StringUtils.isEmpty(adminUserPageQuery.getName())) {
            queryBuilder.name(adminUserPageQuery.getName());
        }
        if (null != adminUserPageQuery.getLevel()) {
            queryBuilder.level(adminUserPageQuery.getLevel());
        }
        List<AdminUser> adminUserList = adminUserMapper.queryAdminUser(queryBuilder.build());
        PageInfo pageInfo = new PageInfo(adminUserList);
        return PageResult.build()
                .setDataList(pageInfo.getList())
                .setTotalPage(pageInfo.getPages())
                .setTotalCount(pageInfo.getTotal())
                .setSuccess(true);
    }

    /**
     * 查询单个
     * @param name
     * @param passwd
     * @return
     */
    public AdminUser queryAdminUserByNameAndPasswd(String name, String passwd) {
        return adminUserMapper.queryAdminUserLimit1(AdminUser.Build().name(name).passwd(passwd).build());
    }

    /**
     * 修改信息
     * @param adminUser
     */
    public void modifiedAdminUser(AdminUser adminUser) {
        adminUserMapper.updateAdminUser(adminUser);
    }

    public AdminUser addAdminUser(AdminUser adminUser) {
        adminUser.setId(adminUserMapper.insertAdminUser(adminUser));
        return adminUser;
    }

    public void deleteAdminUser(Integer id) {
        adminUserMapper.deleteAdminUser(id);
    }
}
