package com.shape.singleproject.mapping.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.ExceptInfo;
/**
*  @author author
*/
public interface ExceptInfoBaseMapper {

    int insertExceptInfo(ExceptInfo object);

    int updateExceptInfo(ExceptInfo object);

    int update(ExceptInfo.UpdateBuilder object);

    List<ExceptInfo> queryExceptInfo(ExceptInfo object);

    ExceptInfo queryExceptInfoLimit1(ExceptInfo object);

}