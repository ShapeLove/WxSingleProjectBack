package com.shape.singleproject.service;

import com.alibaba.fastjson.JSON;
import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.interceptor.LogExceptAop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailForExcept(String methodName, String exceptMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("786627736@qq.com");
        message.setTo("1328445041@qq.com");
        message.setSubject("异常方法:" + methodName);
        message.setText("异常信息: " + exceptMessage);
        mailSender.send(message);
    }

    @LogExceptAop
    public void sendEmail(ExceptInfo exceptInfo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("786627736@qq.com");
        message.setTo("1328445041@qq.com");
        message.setSubject("异常方法:" + exceptInfo.getInvocationName());
        message.setText("异常信息: " + JSON.toJSONString(exceptInfo));
        mailSender.send(message);
    }
}
