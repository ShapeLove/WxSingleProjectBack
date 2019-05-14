package com.shape.singleproject.mapping;


import org.apache.ibatis.annotations.Mapper;
import com.shape.singleproject.mapping.base.TagsBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
@Mapper
public interface TagsMapper extends TagsBaseMapper{

    int deleteTag(Integer tagId);
}