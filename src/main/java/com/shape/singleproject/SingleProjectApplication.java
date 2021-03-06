package com.shape.singleproject;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.logging.LoggersEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.logging.Logger;

@SpringBootApplication
@MapperScan("com.shape.singleproject.mapping")
public class SingleProjectApplication {
    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {

        SingleProjectApplication.context = SpringApplication.run(SingleProjectApplication.class, args);
    }
}
