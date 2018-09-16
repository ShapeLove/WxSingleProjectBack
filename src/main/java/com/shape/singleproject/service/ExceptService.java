package com.shape.singleproject.service;

import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.interceptor.LogExceptAop;
import com.shape.singleproject.mapping.ExceptInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.rmi.MarshalException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ExceptService {

    @Value("${except.overcount}")
    private Integer exceptOverCount;

    @Autowired
    private ExceptInfoMapper exceptInfoMapper;

    @Autowired
    private EmailSendService emailSendService;

    public void processExcept(String methodName, String exceptMessage) {
        try {
            ExceptInfo exceptInfo = exceptInfoMapper.queryExceptInfoLimit1(ExceptInfo.QueryBuild()
                    .invocationName(methodName));
            if (null == exceptInfo) {
                ExceptInfo insertInfo = ExceptInfo.Build()
                        .invocationName(methodName)
                        .modifiedTime(LocalDateTime.now())
                        .lastExceptMessage(exceptMessage)
                        .build();
                exceptInfoMapper.insertExceptInfo(insertInfo);
            }else {
                ExceptInfo.UpdateBuilder updateBuilder = ExceptInfo.UpdateBuild()
                        .set(ExceptInfo.Build()
                                .modifiedTime(LocalDateTime.now())
                                .lastExceptMessage(exceptMessage)
                                .exceptNum(exceptInfo.getExceptNum() + 1)
                                .build())
                        .where(ExceptInfo.ConditionBuild()
                                .idList(exceptInfo.getId()));
                exceptInfoMapper.update(updateBuilder);
            }
        }catch (Exception e) {
            log.error("ExceptService.processExcept error methodName:{}, exceptMessage:{}", methodName, exceptMessage, e);
            emailSendService.sendEmailForExcept(methodName, exceptMessage);
        }
    }

    @LogExceptAop
    public List<ExceptInfo> queryOverTimeExcept() {
        return exceptInfoMapper.queryExceptInfo(ExceptInfo.QueryBuild()
            .exceptNumGreaterEqThan(exceptOverCount));
    }
}
