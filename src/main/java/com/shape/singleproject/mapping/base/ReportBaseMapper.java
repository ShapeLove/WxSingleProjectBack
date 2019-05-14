package com.shape.singleproject.mapping.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shape.singleproject.dto.Report;
/**
*  @author author
*/
public interface ReportBaseMapper {

    int insertReport(Report object);

    int updateReport(Report object);

    int update(Report.UpdateBuilder object);

    List<Report> queryReport(Report object);

    Report queryReportLimit1(Report object);

}