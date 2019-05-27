package com.shape.singleproject.service;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.interceptor.TimeAop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Async
@TimeAop
public class EmailSendService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailForExcept(String methodName, String exceptMessage) {
        try {
            mailSender.send(buildSimpleMailMessageExcept(methodName, exceptMessage, "1328445041@qq.com"), buildSimpleMailMessageExcept(methodName, exceptMessage, "3104288823@qq.com"));
        }catch (Exception e) {
            log.error("EmailSendService.sendEmailForExcept 邮箱服务异常 methodName:{}, exceptMessage:{}", methodName, exceptMessage, e);
        }
    }

    public void sendEmail(ExceptInfo exceptInfo) {
        try {
            mailSender.send(buildSimpleMailMessage(exceptInfo, "1328445041@qq.com"), buildSimpleMailMessage(exceptInfo, "3104288823@qq.com"));
        }catch (Exception e) {
            log.error("EmailSendService.sendEmail 邮箱服务异常 exceptInfo:{}", JSON.toJSONString(exceptInfo), e);
        }
    }

    private SimpleMailMessage buildSimpleMailMessage(ExceptInfo exceptInfo, String sendTo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("786627736@qq.com");
        message.setTo(sendTo);
        message.setSubject("异常方法:" + exceptInfo.getInvocationName());
        message.setText("异常信息: " + JSON.toJSONString(exceptInfo));
        return message;
    }

    private SimpleMailMessage buildSimpleMailMessageExcept(String methodName, String exceptMessage, String sendTo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("786627736@qq.com");
        message.setTo(sendTo);
        message.setSubject("异常方法:" + methodName);
        message.setText("异常信息: " + exceptMessage);
        return message;
    }
}
