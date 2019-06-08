package com.shape.singleproject;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.shape.singleproject.constant.ConstellationEnum;
import com.shape.singleproject.constant.EducationEnum;
import com.shape.singleproject.constant.SexEnum;
import com.shape.singleproject.domain.OpenidValue;
import com.shape.singleproject.domain.UserInfoRandomQuery;
import com.shape.singleproject.domain.UserInfoScrollQuery;
import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.dto.Report;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.interceptor.TimeAop;
import com.shape.singleproject.mapping.ExceptInfoMapper;
import com.shape.singleproject.mapping.UserInfoMapper;
import com.shape.singleproject.service.ExceptService;
import com.shape.singleproject.service.ReportService;
import com.shape.singleproject.service.UserInfoService;
import com.shape.singleproject.util.HttpUtil;
import com.shape.singleproject.vo.Result;
import com.shape.singleproject.vo.UserInfoQuery;
import com.shape.singleproject.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleProjectApplication.class)
@Slf4j
public class TestUserInfoService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ExceptService exceptService;

    @Autowired
    private HttpUtil httpUtil;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ReportService reportService;

    @Test
    public void testInsertUser() throws InterruptedException {
//        List<String> strings = Lists.newArrayList("124123512sdafafs","vcxzxvadsf4352345", "74375658b3d23ce24223bccbb6837a2a");
//        UserInfo userInfo = UserInfo.Build()
//                .name("灬举个栗子13")
//                .openId("geryerywer12312346")
//                .birthday(LocalDate.of(1997, 1, 20))
//                .education(EducationEnum.BENKE.getCode())
//                .sex(SexEnum.GIRL.getCode())
//                .province("黑龙江省")
//                .city("大庆市")
//                .workArea("北京市")
//                .department("商家研发部-商家运营部")
//                .photos(JSON.toJSONString(strings))
//                .wxNumber("houxinchao")
//                .dongdong("houxinchao")
//                .build();
//        try {
////            userInfoService.insertUser(userInfo);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        new CountDownLatch(1).await();
        for (int i=0; i< 20; i++) {
            insertUser("aaf" + i);
        }
    }

    private void insertUser(String code) throws InterruptedException {

        List<String> strings = Lists.newArrayList("82cd1673ca9b1c9f7d448dabe617ddf4");
        OpenidValue openidValue = new OpenidValue();
        openidValue.setOpenId("dfgsdfhfhrwytrt" + code);
        UserInfo userInfo = UserInfo.Build()
                .name("报告大王")
                .openId("gfdgtrytr")
                .birthday(LocalDate.of(1997, 1, 20))
                .education(EducationEnum.BENKE.getCode())
                .sex(SexEnum.GIRL.getCode())
                .province("黑龙江省")
                .city("哈尔滨市")
                .workArea("北京市")
                .department("商家研发部-商家运营部")
                .photos(JSON.toJSONString(strings))
                .wxNumber("dawangnihao")
                .dongdong("dawangnihao")
                .constellation(ConstellationEnum.JINNIU.getCode())
                .height(170)
                .weight(55)
                .build();
        Result result =  userInfoService.insertUser(userInfo,openidValue);
        System.out.println(JSON.toJSONString(result));
        assert result.isSuccess();
    }

    @Test
    public void testQueryUser() {
        List<UserInfo> userInfoList = userInfoService.queryUserInfo(null);
        System.out.println(JSON.toJSONString(userInfoList));
    }

    @Test
    public void testQueryUserByOpenid() {
        System.out.println(JSON.toJSONString(userInfoService.queryUserInfoByOpenid("kjdigujk2341414")));
    }

    @Test
    public void testQueryUserByOpenIdBasic() {
        System.out.println(JSON.toJSONString(userInfoService.queryUserInfoExist("kjdigujk2341414")));
    }

    @Test
    public void testUpdateBasic() {
        UserInfo userInfo = UserInfo.Build()
                .openId("kjdigujk2341414")
                .hobby("吹牛逼").build();
    }

    @Test
    public void testQueryByPage() {

    }

    @Test
    public void testQuerySecret() {
//        System.out.println(JSON.toJSONString(userInfoService.queryUserInfoSecretByOpen("kjdigujk2341414")));
    }

    @Test
    public void testUserInfoScrollQuery() {
        UserInfoScrollQuery userInfoScrollQuery = new UserInfoScrollQuery();
        userInfoScrollQuery.setCreateLt(LocalDateTime.now());
        List<UserInfo> list = userInfoMapper.selectUserInfoByCreateAndModified(userInfoScrollQuery);
        System.out.println(JSON.toJSONString(list));
    }
    @Test
    public void testQueryRondom() {
        UserInfoRandomQuery userInfoRandomQuery = new UserInfoRandomQuery();
        userInfoRandomQuery.setDoingTags(1);
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfoRandom(userInfoRandomQuery);
        System.out.println(JSON.toJSONString(userInfoList));
    }

    @Test
    public void testReportService() {
        Report report = Report.Build()
                .openId("ofn5o5Dpp3qA7OD18BQpyPzhGzpM")
                .reportOpenId("tryfdtgyhftuftuatr")
                .reportType(0)
                .build();
        reportService.addReport(report);
    }

    @Test
    public void testRandomQuery() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        UserInfoRandomQuery userInfoRandomQuery = new UserInfoRandomQuery();
        userInfoRandomQuery.setSize(5);
        List<UserInfo> list = userInfoMapper.queryUserInfoRandom(userInfoRandomQuery);
        stopWatch.stop();
        log.error("randomlist:{} time:{}", JSON.toJSONString(list), stopWatch.getTotalTimeSeconds());
    }

    @Test
    public void testRandomQuery2() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
//        List<Long> ids = userInfoMapper.queryAllId();
        List<Long> ids = Lists.newArrayList(7L, 16L, 18L, 19L, 20L, 21L, 22L, 23L, 24L, 25L, 26L, 27L, 28L, 29L, 30L, 31L, 32L, 33L, 34L, 35L, 36L, 37L, 38L, 39L, 40L, 41L, 42L, 43L, 44L, 45L, 46L, 5L);
        Set<Long> targetId = Sets.newHashSet();
        Random random = new Random();
        while (targetId.size() < 5) {
            int index = random.nextInt(ids.size());
            targetId.add(ids.get(index));
        }
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfo(UserInfo.QueryBuild().idList(Lists.newArrayList(targetId)));
        stopWatch.stop();
        log.error("randomlist:{} time:{}, targetList:{}, listSize:{}", JSON.toJSONString(userInfoList), stopWatch.getTotalTimeSeconds(), targetId, RamUsageEstimator.humanSizeOf(ids));
    }

    @Test
    public void testRandomQuery3() {
        List<UserInfo> userInfoList = userInfoService.randomQueryUserInfo(5, "kjdigujk2341414");
        System.out.println(JSON.toJSONString(userInfoList));
        assert userInfoList.size() == 5;
    }

    @Test
    public void testQueryOtherUser() {
        Result<UserInfoVo> userInfo = userInfoService.getOtherUserInfo("ofn5o5Dpp3qA7OD18BQpyPzhGzpM", "ofn5o5G3Yc8EfLjXJ9HcQ37_DI6M");
        System.out.println(JSON.toJSONString(userInfo));
        assert userInfo.isSuccess();
    }
}
