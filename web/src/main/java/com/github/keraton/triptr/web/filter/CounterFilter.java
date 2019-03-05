package com.github.keraton.triptr.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounterFilter.class);

    private AtomicInteger counter = new AtomicInteger();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        int number = counter.incrementAndGet();
        chain.doFilter(request, response);
        LOGGER.info("Counter number {}", number);
    }
}
