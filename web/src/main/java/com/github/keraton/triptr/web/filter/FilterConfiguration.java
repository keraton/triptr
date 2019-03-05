package com.github.keraton.triptr.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<CounterFilter> loggingFilter(){
        FilterRegistrationBean<CounterFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CounterFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

}
