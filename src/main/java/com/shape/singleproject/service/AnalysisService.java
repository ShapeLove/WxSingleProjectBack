package com.shape.singleproject.service;

import com.shape.singleproject.dto.CityCountDo;
import com.shape.singleproject.domain.DateCountQuery;
import com.shape.singleproject.dto.DateCountDo;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.AdminUserMapper;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.util.DateUtil;
import com.shape.singleproject.vo.DateCountResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据分析服务
 */
@Service
// 打印日志
@LogExceptAop
// 统计方法调用时间
@TimeAop
public class AnalysisService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    /**
     * 按照城市分析用户数量
     * @return
     */
    public List<CityCountDo> analysisCityUserCount() {
        return userInfoMapper.analysisCityUserCount();
    }

    /**
     * 根据时间分析用户数据
     * @return
     */
    public DateCountResult analysisUserCount(LocalDateTime targetDate, Integer size) {
        if (targetDate == null) {
            targetDate = LocalDateTime.now();
        }
        if (size == null) {
            size = 7;
        }else {
            if (size == 0) {
                return new DateCountResult();
            }
        }

        // 1.生成连续的时间序列 按照天
        List<String> dateTimeKey = DateUtil.generateDateDaySequence(targetDate, size);
        DateCountQuery dateCountQuery = new DateCountQuery();
        dateCountQuery.setTargetDate(DateUtil.getDateString(targetDate));
        dateCountQuery.setSize(size);

        // 2.查询数据库中以当前天为准有size天的数据 可能不连续 但肯定时间范围要比时间序列更小
        List<DateCountDo> dateCountDos = userInfoMapper.analysisUserCountByDate(dateCountQuery);
        // 3. 查询全部数据
        long totalCount = userInfoMapper.queryAllUserCount();

        // 4.处理数据 从时间序列中找数据库结果中是否有，没有就是0有就是数据库中的值
        List<Integer> dataList = dateTimeKey.stream()
                .map(x-> dateCountDos.stream().filter(temp -> temp.getDateString().equals(x)).findFirst()
                    .map(DateCountDo::getValue).orElse(0))
                .collect(Collectors.toList());
        return new DateCountResult(totalCount, dateTimeKey, dataList);
    }

    /**
     * 根据时间分析管理员数据
     * @return
     */
    public DateCountResult analysisAdminUserCount(LocalDateTime targetDate, Integer size) {
        if (targetDate == null) {
            targetDate = LocalDateTime.now();
        }
        if (size == null) {
            size = 7;
        }else {
            if (size == 0) {
                return new DateCountResult();
            }
        }
        // 1.生成连续的时间序列 按照天
        List<String> dateTimeKey = DateUtil.generateDateDaySequence(targetDate, size);
        DateCountQuery dateCountQuery = new DateCountQuery();
        dateCountQuery.setTargetDate(DateUtil.getDateString(targetDate));
        dateCountQuery.setSize(size);

        // 2.查询数据库中以当前天为准有size天的数据 可能不连续 但肯定时间范围要比时间序列更小
        List<DateCountDo> dateCountDos = adminUserMapper.analysisAdminUserCountByDate(dateCountQuery);
        // 3. 查询全部数据
        long totalCount = adminUserMapper.queryAllAdminUserCount();

        // 4.处理数据 从时间序列中找数据库结果中是否有，没有就是0有就是数据库中的值
        List<Integer> dataList = dateTimeKey.stream()
                .map(x-> dateCountDos.stream().filter(temp -> temp.getDateString().equals(x)).findFirst()
                        .map(DateCountDo::getValue).orElse(0))
                .collect(Collectors.toList());
        return new DateCountResult(totalCount, dateTimeKey, dataList);
    }
}
