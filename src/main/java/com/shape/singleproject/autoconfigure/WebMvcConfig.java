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

    /**
     * 可以通过配置项 shape.enable.loginfilter 控制是否开启小程序端登录拦截
     */
    @Value("${shape.enable.loginfilter:true}")
    private boolean enableLoginFilter;

    /**
     * 添加过滤器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 1.全局都加入cors跨域处理
        registry.addInterceptor(new CorsFilter()).addPathPatterns("/**");
        if (enableLoginFilter) {
            // 2.小程序登录拦截 除了 /login/**","/except/**","/admin/**","/getAllCache", "/error 这些url以外都会被拦截
            registry.addInterceptor(new LoginFilter()).addPathPatterns("/**").excludePathPatterns("/login/**","/except/**","/admin/**","/getAllCache", "/error");
        }
        registry.addInterceptor(new AdminLoginFilter()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**");
    }

    /**
     * 控制文件上传大小
     * @return
     */
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
