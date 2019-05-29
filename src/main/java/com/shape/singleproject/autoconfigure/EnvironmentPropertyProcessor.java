package com.shape.singleproject.autoconfigure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;

public class EnvironmentPropertyProcessor implements EnvironmentPostProcessor {
    private static final String devName = "applicationConfig: [classpath:/application-dev.properties]";
    private static final String prodName = "applicationConfig: [classpath:/application-prod.properties]";
    private static final String defaultName = "applicationConfig: [classpath:/application.properties]";
    private static final String passWdKey = "spring.datasource.password";
    private static final String passWdDataKey = "spring.datasource.druid.password";
    private static final String imageServerUrlKey = "shape.imageserver.url";
    private static final String emailPasswdKey = "spring.mail.password";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources mutablePropertySources = environment.getPropertySources();
        PropertySource<LinkedHashMap<String, String>> devProfile = (PropertySource<LinkedHashMap<String, String>>) mutablePropertySources.get(devName);
        if (devProfile != null) {
            getPropertyAndSetFromPropertySource(passWdKey, devProfile, "123456");
            getPropertyAndSetFromPropertySource(passWdDataKey, devProfile, "123456");
            getPropertyAndSetFromPropertySource(imageServerUrlKey, devProfile, "http://zimg.shpcoder.cn");
        }
        PropertySource<LinkedHashMap<String, String>> prodProfile = (PropertySource<LinkedHashMap<String, String>>) mutablePropertySources.get(prodName);
        if (prodProfile != null) {
            getPropertyAndSetFromPropertySource(passWdKey, prodProfile, "123456");
            getPropertyAndSetFromPropertySource(passWdDataKey, prodProfile, "123456");
            getPropertyAndSetFromPropertySource(imageServerUrlKey, prodProfile, "http://zimg.shpcoder.cn");
        }
        PropertySource<LinkedHashMap<String, String>> defaultProfile = (PropertySource<LinkedHashMap<String, String>>) mutablePropertySources.get(defaultName);
        getPropertyAndSetFromPropertySource(emailPasswdKey, defaultProfile, "lctvuirjtrstbbie");
    }

    private void getPropertyAndSetFromPropertySource(String key, PropertySource<LinkedHashMap<String,String>> propertySource, String value) {
        if (propertySource == null) {
            return;
        }
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
