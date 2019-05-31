package com.shape.singleproject.admin;

import com.shape.singleproject.dto.CityCountDo;
import com.shape.singleproject.service.AnalysisService;
import com.shape.singleproject.vo.DateCountResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理端数据分析
 */
@RestController
@RequestMapping("/admin/analysis")
@Slf4j
public class AdminAnalysisController {

    @Resource
    private AnalysisService analysisService;

    /**
     * 分析用户城市
     * @return
     */
    @GetMapping("/userCountByCity")
    public List<CityCountDo> userCountByCity() {
        return analysisService.analysisCityUserCount();
    }

    /**
     * 根据时间统计用户数量
     * @param targetDate
     * @param size
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
