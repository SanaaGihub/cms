package com.exercice.cms.config;

import com.exercice.cms.filter.MyNewFilter;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {
    @Bean
    public FilterRegistrationBean<MyNewFilter> registrationBean() {
        FilterRegistrationBean<MyNewFilter> registrationBean=new FilterRegistrationBean<>() ;
    registrationBean.setFilter(new MyNewFilter());
    registrationBean.addUrlPatterns("/customers/*");
    return registrationBean;
    }
}
