package com.shape.singleproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.shape.singleproject.domain.OpenidValue;
import com.shape.singleproject.dto.Report;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.service.ReportService;
import com.shape.singleproject.service.TagService;
import com.shape.singleproject.service.UserInfoService;
import com.shape.singleproject.util.WebUtil;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import com.shape.singleproject.vo.UserInfoQuery;
import com.shape.singleproject.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private ReportService reportService;

    @Resource
    private TagService tagService;


    @PostMapping("/queryByPage")
    public PageResult<UserInfo> queryByPage(@RequestBody UserInfoQuery userInfoQuery) {
        PageResult<UserInfo> result = new PageResult();
        try {
            result = userInfoService.queryUserInfoByPage(userInfoQuery, WebUtil.getCurrentUserOpenId());
        }catch (Exception e) {
            log.error("UserController.queryByPage error userInfoQuery:{}", JSON.toJSONString(userInfoQuery), e);
            result.setMessage("服务器繁忙，请稍后重试！");
        }
        return result;
    }

    @PostMapping("uploadImg")
    public JSONObject uploadImg(MultipartFile file) {
        try {
            return userInfoService.uploadImg(file);
        }catch (Exception e) {
            log.error("UserController.uploadImg error ", e);
        }
        return null;
    }

    @RequestMapping("deleteImg/{md5}")
    public boolean deleteImg(@PathVariable("md5") String md5) {
        try {
            return userInfoService.deleteImg(md5);
        }catch (Exception e) {
            log.error("UserController.deleteImg error md5:{}", md5, e);
        }
        return false;
    }

    /**
     * 查询个人信息
     * @return
     */
    @RequestMapping("getUserInfo")
    public UserInfo getUserInfo() {
        try {
            String openId = WebUtil.getCurrentUserOpenId();

            if (StringUtils.isEmpty(openId)) {
                return null;
            }

            return userInfoService.queryUserInfoByOpenIdNonSecurity(openId);
        } catch (Exception e) {
            log.error("UserController.getUserInfo error ", e);
            return null;
        }
    }

    /**
     * 新增个人信息
     *
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "saveUserInfo", method = RequestMethod.POST)
    public Result saveUserInfo(@RequestBody UserInfo userInfo) {
        Result result = new Result();
        try {
            OpenidValue openidValue = WebUtil.getCurrentUserOpenidValue();
            if (null == openidValue) {
                result.setMessage("沒有登录信息，请重新进入小程序进行登录！");
                return result;
            }

            result = userInfoService.insertUser(userInfo, openidValue);
        } catch (Exception e) {
            log.error("UserController.saveUserInfo error userInfo:{}", JSON.toJSONString(userInfo), e);
            result.setMessage("服务器繁忙，请稍后重试！");
        }
        return result;
    }

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
    public Result updateUserInfo(@RequestBody UserInfo userInfo) {
        Result  result = new Result();
        try {
            OpenidValue openidValue = WebUtil.getCurrentUserOpenidValue();
            if (StringUtils.isEmpty(openidValue.getOpenId())) {
                result.setMessage("沒有登录信息，请重新进入小程序进行登录！");
                return result;
            }
            userInfo.setOpenId(openidValue.getOpenId());

            result = userInfoService.updateUserInfoBasic(userInfo, openidValue);
        } catch (Exception e) {
            log.error("UserController.updateUserInfo error userInfo:{}", JSON.toJSONString(userInfo), e);
            result.setMessage("服务器繁忙，请稍后重试！");
        }

        return result;
    }

    @RequestMapping(value = "getOtherUserInfo", method = RequestMethod.POST)
    public Result<UserInfoVo> getOtherUserInfo(@RequestBody String openId) {
        Result<UserInfoVo> result = new Result<>();

        try {
            if (StringUtils.isEmpty(openId)) {
                result.setMessage("openId不能为空");
                return result;
            }

            OpenidValue openidValue = WebUtil.getCurrentUserOpenidValue();
            if (StringUtils.isEmpty(openidValue.getOpenId())) {
                result.setMessage("沒有登录信息，请重新进入小程序进行登录！");
                return result;
            }
            return userInfoService.getOtherUserInfo(openId, openidValue.getOpenId());
        } catch (Exception e) {
            log.error("UserController.getOtherUserInfo error userInfo:{}", openId, e);
            result.setMessage("服务器繁忙，请稍后重试！");
        }
        return result;
    }

    @GetMapping("/randomQueryUserInfos")
    public List<UserInfo> randomQueryUserInfos(@RequestParam(value = "size", required = false) Integer size) {
        String openId = WebUtil.getCurrentUserOpenId();
        try {
            return userInfoService.randomQueryUserInfo(size, openId);
        }catch (Exception e) {
            log.error("UserController.randomQueryUserInfos error size:{}, openId:{}", size, openId, e);
            return Lists.newArrayList();
        }
    }

    /**
     * 用户关注
     * @param openId 要关注的用户的OpenId
     * @return
     */
    @PostMapping("attentionAction")
    public JSONObject attentionAction(@RequestBody String openId) {
        JSONObject result;
        try {
            String currentOpenId = WebUtil.getCurrentUserOpenId();
            result = userInfoService.attentionAction(openId, currentOpenId);
            return result;
        } catch (Exception e) {
            log.error("UserController.attentionAction error openId:{}", openId, e);
            return null;
        }
    }

    /**
     * 用户取消关注
     * @param openId 用户要取消的关注用户的OpenId
     */
    @PostMapping("cancelAttention")
    public boolean cancelAttention(@RequestBody String openId) {
        try {
            String currentOpenId = WebUtil.getCurrentUserOpenId();
            return userInfoService.cancelAttentionAction(openId, currentOpenId);
        } catch (Exception e) {
            log.error("UserController.cancelAttention error openId:{}", openId, e);
            return false;
        }
    }

    /**
     * 获取用户微信号
     * @param openId
     * @return
     */
    @PostMapping("getUserSecurity")
    public String getUserSecurity(@RequestBody String openId) {
        try {
            String currentOpenId = WebUtil.getCurrentUserOpenId();
            return Optional.ofNullable(userInfoService.queryUserInfoSecretByOpen(openId, currentOpenId))
                    .map(UserInfo::getWxNumber)
                    .orElse(null);
        } catch (Exception e) {
            log.error("UserController.getUserSecurity error openId:{}", openId, e);
            return null;
        }
    }

    /**
     * 举报
     * @param report
     * @return
     */
    @PostMapping("/report")
    public Result report(@RequestBody Report report) {
        try {
            String currentOpenId = WebUtil.getCurrentUserOpenId();
            report.setOpenId(currentOpenId);
            reportService.addReport(report);
            return Result.successResult();
        } catch (DuplicateKeyException e) {
            log.error("UserController.report error report:{}", JSON.toJSONString(report), e);
            return Result.failtResult("该举报信息已存在");
        }catch (Exception e) {
            log.error("UserController.report error report:{}", JSON.toJSONString(report), e);
            return null;
        }
    }

    /**
     * 随机获取指定数量的标签
     * @param tagType
     * @param size
     * @return
     */
    @GetMapping("/randomQueryTags")
    public Result randomQueryTags(@RequestParam Integer tagType, @RequestParam Integer size) {
        try {
            String currentOpenId = WebUtil.getCurrentUserOpenId();
            if (StringUtils.isEmpty(currentOpenId)) {
                return Result.failtResult("用户未登录");
            }
            return Result.successResultWithData(tagService.randomQueryTags(size, tagType));
        } catch (Exception e) {
            log.error("UserController.randomQueryTags error tagType:{}, size:{}", tagType, size, e);
            return null;
        }
    }

    /**
     * 随机查询指定数量的用户信息
     * @param size
     * @return
     */
    @GetMapping("/randomQueryUserInfo")
    public List<UserInfo> randomQueryUserInfo(@RequestParam Integer size) {
        if (null == size) {
            return Lists.newArrayList();
        }
        return userInfoService.randomQueryUserInfo(size, WebUtil.getCurrentUserOpenId());
    }
}
