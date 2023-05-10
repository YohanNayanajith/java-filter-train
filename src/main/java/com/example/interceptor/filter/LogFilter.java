package com.example.interceptor.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogFilter implements Filter {
    public static final String CORRELATION_ID_HEADER_KEY = "X-Correlation-Id";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final String correlationId = StringUtils.isNotEmpty(httpServletRequest.getHeader(CORRELATION_ID_HEADER_KEY)) ?
                httpServletRequest.getHeader(CORRELATION_ID_HEADER_KEY) : UUID.randomUUID().toString();
        log.info("Correlation ID {}",correlationId);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
