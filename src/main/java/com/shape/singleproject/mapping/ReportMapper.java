package com.shape.singleproject.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.Report;
import com.shape.singleproject.mapping.base.ReportBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
@Mapper
public interface ReportMapper extends ReportBaseMapper{

    int deleteReport(Integer reportId);
}