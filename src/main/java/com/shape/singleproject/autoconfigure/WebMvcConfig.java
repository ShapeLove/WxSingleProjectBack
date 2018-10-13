package com.shape.singleproject.autoconfigure;

import com.shape.singleproject.filter.CorsFilter;
import com.shape.singleproject.filter.LoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web相关配置
 * 1.过滤拦截器
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CorsFilter()).addPathPatterns("/**");
        registry.addInterceptor(new LoginFilter()).addPathPatterns("/**").excludePathPatterns("/login/**");
    }
}
