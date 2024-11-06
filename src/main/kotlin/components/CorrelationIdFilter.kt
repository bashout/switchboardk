package org.bashout.switchboardk.components
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.MDC
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CorrelationIdFilter : Filter {

    companion object {
        private const val CORRELATION_ID_HEADER = "X-request-id"
        private const val MDC_CORRELATION_ID_KEY = "correlationId"
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val httpRequest = request as HttpServletRequest

        val correlationId = httpRequest.getHeader(CORRELATION_ID_HEADER) ?: UUID.randomUUID().toString()
        try {
            MDC.put(MDC_CORRELATION_ID_KEY, correlationId)
            chain.doFilter(request, response)
        } finally {
            MDC.remove(MDC_CORRELATION_ID_KEY)
        }
    }
}