package com.shop.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebappConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
