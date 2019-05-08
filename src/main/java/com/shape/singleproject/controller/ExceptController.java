package com.shape.singleproject.controller;

import com.shape.singleproject.dto.TestExceptInfo;
import com.shape.singleproject.service.TestExceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //注解  打个标签证明这个雷士一个Controller类型  restfulURL：意识是 专门给前端返回json字符串的便是
@RequestMapping("/except")  //开始拼接前端接口url  当前url www.shpcoder.cn/except
public class ExceptController {

    @Autowired
    private TestExceptService testExceptService;

    @RequestMapping("/list") //在url上继续拼接list 当前url www.shpcoder.cn/except/list
    public List<TestExceptInfo> list(){
        return testExceptService.queryExceptList();
    }
}
