package com.github.keraton.triptr.web.filter

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class FilterConfiguration {

    @Bean
    open fun loggingFilter(): FilterRegistrationBean<CounterFilter> {
        val registrationBean = FilterRegistrationBean<CounterFilter>()

        registrationBean.filter = CounterFilter()
        registrationBean.addUrlPatterns("/*")

        return registrationBean
    }

}
