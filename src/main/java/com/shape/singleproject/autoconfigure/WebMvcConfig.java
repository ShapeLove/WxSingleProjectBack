package com.shape.singleproject.autoconfigure;

import com.shape.singleproject.filter.AdminLoginFilter;
import com.shape.singleproject.filter.CorsFilter;
import com.shape.singleproject.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * Web相关配置
 * 1.过滤拦截器
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${shape.enable.loginfilter:true}")
    private boolean enableLoginFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CorsFilter()).addPathPatterns("/**");
        if (enableLoginFilter) {
            registry.addInterceptor(new LoginFilter()).addPathPatterns("/**").excludePathPatterns("/login/**","/except/**","/admin/**","/getAllCache", "/error");
        }
        registry.addInterceptor(new AdminLoginFilter()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**");
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize("2MB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }
}
