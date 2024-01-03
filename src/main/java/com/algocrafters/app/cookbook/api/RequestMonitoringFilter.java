package com.algocrafters.app.cookbook.api;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.UUID;

/**
 * A class serving as a DTO to carry data to/from persistent {@code UserDetailsEntity} objects to the API layer.
 *
 * @author Vitali Tchalov (github/VitaliTch)
 * @author {name}
 *
 * @since 0.1
 */
@Component
@Order(1)
public class RequestMonitoringFilter extends GenericFilterBean {
    // The base class provides a logger via a protected field, but we want to use SLF4J throughout the application
    private static final Logger log = LoggerFactory.getLogger(RequestMonitoringFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        long beganRequestProcessingAt = System.currentTimeMillis();

        MDC.clear();
        MDC.put("RequestID",  UUID.randomUUID().toString());

        // When the request is forwarded, for example when deployed behind a load balancer, the request holds the IP of the balancer in RemoteAddr,
        // whereas the true remote address of the client that sent the request is placed into the "X-Forwarded-For" header.
        String remoteAddr = httpServletRequest.getHeader("X-Forwarded-For");
        MDC.put("RemoteAddr", StringUtils.isBlank(remoteAddr) ? servletRequest.getRemoteAddr() : remoteAddr);

        filterChain.doFilter(httpServletRequest, servletResponse);

        log.info("Request processing completed. RequestDurationMillis={} ms", System.currentTimeMillis() - beganRequestProcessingAt);

        MDC.clear();
    }
}

