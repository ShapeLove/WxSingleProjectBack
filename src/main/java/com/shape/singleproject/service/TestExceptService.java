package com.shape.singleproject.service;

import com.shape.singleproject.dto.ExceptInfo;
import com.shape.singleproject.dto.TestExceptInfo;
import com.shape.singleproject.mapping.TestExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service  //标注当前类是一个service 处理业务逻辑
public class TestExceptService {

    @Resource  //依赖注入  从Spring框架定义的mapper中获取接口
    private TestExceptionMapper testExceptionMapper; //获取Java Mapper中转换的接口结果

    public List<TestExceptInfo> queryExceptList(){
        return testExceptionMapper.queryExceptInfoList();
    }
}
