package com.shape.singleproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shape.singleproject.constant.TagTypeEnum;
import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.TagsMapper;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.vo.BaseQuery;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.TagPageQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签服务
 */
@Service
@LogExceptAop
@TimeAop
public class TagService {

    @Resource
    private TagsMapper tagsMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 新增标签
     * @param tags
     */
    public Tags addTag(Tags tags) {
        tagsMapper.insertTags(tags);
        return tags;
    }

    /**
     * 标签分页查询
     * @param tagPageQuery
     * @return
     */
    public PageResult<Tags> queryTagsByPage(TagPageQuery tagPageQuery) {
        PageHelper.startPage(tagPageQuery.getPageIndex(), tagPageQuery.getPageSize());
        Tags.QueryBuilder queryBuilder = Tags.QueryBuild();
        queryBuilder.fetchAll();
        if (!StringUtils.isEmpty(tagPageQuery.getTagName())) {
            queryBuilder.tagName(tagPageQuery.getTagName());
        }
        if (null != tagPageQuery.getTagType()) {
            queryBuilder.tagType(tagPageQuery.getTagType());
        }
        List<Tags> tagList = tagsMapper.queryTags(queryBuilder.build());
        PageInfo pageInfo = new PageInfo(tagList);
        return PageResult.build()
                .setDataList(pageInfo.getList())
                .setTotalPage(pageInfo.getPages())
                .setTotalCount(pageInfo.getTotal())
                .setSuccess(true);
    }

    /**
     * 根据标签名字或者标签id查询单个标签
     * @param tagName
     * @return
     */
    public Tags queryOneTagByNameAndId(Integer id,String tagName) {
        Tags.QueryBuilder queryBuilder = Tags.QueryBuild();
        if (null == id) {
            queryBuilder.id(id);
        }

        if (!StringUtils.isEmpty(tagName)) {
            queryBuilder.tagName(tagName);
        }
        return tagsMapper.queryTagsLimit1(queryBuilder.build());
    }

    /**
     * 删除标签
     * @param id
     */
    @Transactional
    public void deleteTag(Integer id, Integer tagType) {
        // 删除标签
        tagsMapper.deleteTag(id);

        if (tagType.equals(TagTypeEnum.ACTIVITY.getTagCode())) {
            // 带有该标签的用户标签设为null
            userInfoMapper.update(UserInfo.UpdateBuild()
                    .set(UserInfo.Build().activityTags(null).build())
                    .where(UserInfo.ConditionBuild().activityTagsList(id).build())
            );
        }

        if (tagType.equals(TagTypeEnum.DOING.getTagCode())) {
            // 带有该标签的用户标签设为null
            userInfoMapper.update(UserInfo.UpdateBuild()
                    .set(UserInfo.Build().doingTags(null).build())
                    .where(UserInfo.ConditionBuild().doingTagsList(id).build())
            );
        }

        if (tagType.equals(TagTypeEnum.PLAN.getTagCode())) {
            // 带有该标签的用户标签设为null
            userInfoMapper.update(UserInfo.UpdateBuild()
                    .set(UserInfo.Build().planTags(null).build())
                    .where(UserInfo.ConditionBuild().planTagsList(id).build())
            );
        }

    }
}