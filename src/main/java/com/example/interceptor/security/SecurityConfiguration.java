package com.example.interceptor.security;

import com.example.interceptor.filter.LogFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

    @Bean
    public FilterRegistrationBean<LogFilter> myFilterRegistration() {
        FilterRegistrationBean<LogFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new LogFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LogFilter logFilter = new LogFilter();
        http.authorizeRequests().antMatchers("/login/**","/api/product/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
//        http.addFilter(logFilter);
        http.csrf().disable().cors().and().headers().frameOptions().disable();
    }
}
