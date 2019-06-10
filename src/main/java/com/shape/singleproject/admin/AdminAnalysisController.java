package com.shape.singleproject.admin;

import com.shape.singleproject.dto.CityCountDo;
import com.shape.singleproject.service.AnalysisService;
import com.shape.singleproject.vo.DateCountResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理端数据分析
 */

// rest :json形式返回结果 conroller表示是url接口层
@RestController
@RequestMapping("/admin/analysis")
// lombok插件 注解作用 log
@Slf4j
public class AdminAnalysisController {

    /**
     * conroller -> service -> mapper 数据库映射
     * 管理端数据分析服务
     */
    @Resource
    private AnalysisService analysisService;

    /**
     * 分析用户城市
     * 按照城市维度查询用户数量
     * /admin/analysis/userCountByCity
     * Get Post http
     * @return
     */
    @GetMapping("/userCountByCity")
    public List<CityCountDo> userCountByCity() {
        return analysisService.analysisCityUserCount();
    }

    /**
     * 根据时间统计用户数量
     * @param targetDate 起始时间
     * @param size 从起始时间开始倒数n天
     * @return
     */
    @GetMapping("/userCountByDate")
    public DateCountResult userCountByDate(@RequestParam(value ="targetDate", required = false) LocalDateTime targetDate, @RequestParam(value = "size", required = false) Integer size) {
        return analysisService.analysisUserCount(targetDate, size);
    }

    /**
     * 根据时间统计管理员用户数量
     * @param targetDate
     * @param size
     * @return
     */
    @GetMapping("/adminUserCountByDate")
    public DateCountResult adminUserCountByDate(@RequestParam(value ="targetDate", required = false) LocalDateTime targetDate, @RequestParam(value = "size", required = false) Integer size) {
        return analysisService.analysisAdminUserCount(targetDate, size);
    }
}
