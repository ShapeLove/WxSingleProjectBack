package com.shape.singleproject.autoconfigure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;

/**
 * 环境配置处理
 * 由于密码等私密信息配置在配置文件中会导致不太安全
 * 所以需要通过该自动配置进行处理
 * EnvironmentPostProcessor 这个接口是spring提供的生命周期回调接口 在加载完配置文件后并在初始化spring上下文之前触发
 */
public class EnvironmentPropertyProcessor implements EnvironmentPostProcessor {
    /**
     * 测试环境配置文件在Spring环境配置map中对应的key
     */
    private static final String devName = "applicationConfig: [classpath:/application-dev.properties]";
    /**
     * 生产环境配置文件在Spring环境配置map中对应的key
     */
    private static final String prodName = "applicationConfig: [classpath:/application-prod.properties]";
    /**
     * 默认通用配置文件在Spring环境配置map中对应的key
     */
    private static final String defaultName = "applicationConfig: [classpath:/application.properties]";
    /**
     * database密码
     */
    private static final String passWdKey = "spring.datasource.password";
    private static final String passWdDataKey = "spring.datasource.druid.password";
    /**
     * 图片服务器url
     */
    private static final String imageServerUrlKey = "shape.imageserver.url";
    /**
     * 邮件系统密码
     */
    private static final String emailPasswdKey = "spring.mail.password";

    /**
     * 触发的事件回调方法
     * @param environment 整体环境配置信息
     * @param application Spring应用启动类
     */
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 1.获取环境所有的配置文件信息
        MutablePropertySources mutablePropertySources = environment.getPropertySources();

        // 2.找到测试环境配置文件
        PropertySource<LinkedHashMap<String, String>> devProfile = (PropertySource<LinkedHashMap<String, String>>) mutablePropertySources.get(devName);
        if (devProfile != null) {
            // 3.如果不为空的话把要赋值的配置值设置上 其实是替换 这里使用了通用方法传入要替换属性值的属性的key，配置文件的源PropertySource，最后是要添加的属性值
            // 下面的做法一样
            getPropertyAndSetFromPropertySource(passWdKey, devProfile, "shapehou");
            getPropertyAndSetFromPropertySource(passWdDataKey, devProfile, "shapehou");
            getPropertyAndSetFromPropertySource(imageServerUrlKey, devProfile, "http://zimg.shpcoder.cn");
        }
        PropertySource<LinkedHashMap<String, String>> prodProfile = (PropertySource<LinkedHashMap<String, String>>) mutablePropertySources.get(prodName);
        if (prodProfile != null) {
            getPropertyAndSetFromPropertySource(passWdKey, prodProfile, "shapehou");
            getPropertyAndSetFromPropertySource(passWdDataKey, prodProfile, "shapehou");
            getPropertyAndSetFromPropertySource(imageServerUrlKey, prodProfile, "http://zimg.shpcoder.cn");
        }
        PropertySource<LinkedHashMap<String, String>> defaultProfile = (PropertySource<LinkedHashMap<String, String>>) mutablePropertySources.get(defaultName);
        getPropertyAndSetFromPropertySource(emailPasswdKey, defaultProfile, "lctvuirjtrstbbie");
    }

    /**
     * 通用增加配置文件配置方法
     * @param key 要增加属性值的配置的key
     * @param propertySource 配置文件的属性源对象
     * @param value 要增加的属性值
     */
    private void getPropertyAndSetFromPropertySource(String key, PropertySource<LinkedHashMap<String,String>> propertySource, String value) {
        if (propertySource == null) {
            return;
        }
        // 1.从配置文件属性源中根据key查找对应的属性值是否为空为空才会给该属性增加属性值
        Object property = propertySource.getProperty(key);
        if (property == null) {
            return;
        }
        String propertyStr = (String) property;
        if (StringUtils.isEmpty(propertyStr)) {
            propertySource.getSource().put(key, value);
        }
    }
}
