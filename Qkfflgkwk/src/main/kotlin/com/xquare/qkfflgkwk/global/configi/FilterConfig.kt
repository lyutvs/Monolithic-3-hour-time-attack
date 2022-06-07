package com.xquare.qkfflgkwk.global.configi

import com.fasterxml.jackson.databind.ObjectMapper
import com.xquare.qkfflgkwk.global.error.ExceptionFilter
import com.xquare.qkfflgkwk.global.security.jwt.JwtTokenFilter
import com.xquare.qkfflgkwk.global.security.jwt.JwtTokenResolver
import com.xquare.qkfflgkwk.global.security.jwt.JwtTokenProvider
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtTokenResolver: JwtTokenResolver,
    private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {
        val tokenFilter = JwtTokenFilter(jwtTokenResolver, jwtTokenProvider)
        val exceptionFilter = ExceptionFilter(objectMapper)
        builder.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(exceptionFilter, JwtTokenFilter::class.java)
    }
}
