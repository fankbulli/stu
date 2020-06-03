package com.ty.mb.zm.stu.config;

import com.ty.mb.zm.stu.filter.WebFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: stu
 * @description: 过滤器配置
 * @author: zhongming
 * @time: 2020/6/3 14:10
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new WebFilter());
        registration.addUrlPatterns("/*");
        registration.setName("webFilter");
        registration.setOrder(1);
        return registration;
    }

}

