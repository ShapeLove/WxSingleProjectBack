package com.shape.singleproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shape.singleproject.domain.OpenidValue;
import com.shape.singleproject.dto.UserInfo;
import com.shape.singleproject.service.UserInfoService;
import com.shape.singleproject.util.WebUtil;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import com.shape.singleproject.vo.UserInfoQuery;
import com.sun.deploy.net.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("/queryByPage")
    public PageResult<UserInfo> queryByPage(@RequestBody UserInfoQuery userInfoQuery) {
        PageResult<UserInfo> result = new PageResult();
        try {
            result = userInfoService.queryUserInfoByPage(userInfoQuery);
        }catch (Exception e) {
            log.error("UserController.queryByPage error userInfoQuery:{}", JSON.toJSONString(userInfoQuery), e);
            result.setMessage("服务器繁忙，请稍后重试！");
        }
        return result;
    }

    @RequestMapping("uploadImg")
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
            String openId = WebUtil.getCurrentUserOpenId();
            if (StringUtils.isEmpty(openId)) {
                result.setMessage("沒有登录信息，请重新进入小程序进行登录！");
                return result;
            }

            result = userInfoService.updateUserInfoBasic(userInfo);
        } catch (Exception e) {
            log.error("UserController.updateUserInfo error userInfo:{}", JSON.toJSONString(userInfo), e);
            result.setMessage("服务器繁忙，请稍后重试！");
        }

        return result;
    }

}
