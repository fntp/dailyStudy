package com.xuexi.config;

import com.xuexi.filter.MyHttpRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fntp
 * @since 2024/11/20
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<MyHttpRequestFilter> registrationBean() {
        FilterRegistrationBean<MyHttpRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyHttpRequestFilter());
        // 指定Filter的路径
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }

}
