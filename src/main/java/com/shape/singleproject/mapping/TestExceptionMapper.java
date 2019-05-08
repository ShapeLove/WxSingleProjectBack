package com.shape.singleproject.mapping;

import com.shape.singleproject.dto.TestExceptInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Spring框架的注解   表示是访问数据库
@Mapper  //Mybatis框架的注解   表示是与xml映射的java类
public interface TestExceptionMapper {
    List<TestExceptInfo> queryExceptInfoList();
}
