package com.shape.singleproject.mapping.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.Tags;
/**
*  @author author
*/
public interface TagsBaseMapper {

    int insertTags(Tags object);

    int updateTags(Tags object);

    int update(Tags.UpdateBuilder object);

    List<Tags> queryTags(Tags object);

    Tags queryTagsLimit1(Tags object);

}