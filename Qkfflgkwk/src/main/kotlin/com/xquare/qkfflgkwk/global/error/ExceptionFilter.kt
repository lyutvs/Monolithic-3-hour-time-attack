package com.xquare.qkfflgkwk.global.error

import com.fasterxml.jackson.databind.ObjectMapper
import com.xquare.qkfflgkwk.global.error.exception.InternalServerError
import com.xquare.qkfflgkwk.global.error.propertys.CustomExceptionResponse
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (exception: Exception) {
            when (exception) {
                is CustomException -> writeErrorCode(exception, response)
                else -> writeErrorCode(InternalServerError.EXCEPTION, response)
            }
        }
    }

    private fun writeErrorCode(exception: CustomException, response: HttpServletResponse) {
        val errorResponse = CustomExceptionResponse.of(exception)

        response.contentType = "application/json"
        response.status = errorResponse.status
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}