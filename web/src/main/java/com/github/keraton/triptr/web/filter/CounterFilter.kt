package com.github.keraton.triptr.web.filter

import org.slf4j.LoggerFactory
import java.io.IOException
import java.util.concurrent.atomic.AtomicInteger
import javax.servlet.*

class CounterFilter : Filter {

    private val counter = AtomicInteger()

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val number = counter.incrementAndGet()
        chain.doFilter(request, response)
        LOGGER.info("Counter number {}", number)
    }

    companion object  {
        private val LOGGER = LoggerFactory.getLogger(CounterFilter::class.java)
    }
}
