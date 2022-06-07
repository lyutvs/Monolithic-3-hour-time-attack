package com.xquare.qkfflgkwk.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.xquare.qkfflgkwk.global.configi.FilterConfig
import com.xquare.qkfflgkwk.global.security.jwt.JwtTokenProvider
import com.xquare.qkfflgkwk.global.security.jwt.JwtTokenResolver
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.web.cors.CorsUtils

@Component
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtTokenResolver: JwtTokenResolver,
    private val objectMapper: ObjectMapper
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .formLogin().disable()
            .cors()

            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeRequests()
            .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

            // auth
            .antMatchers(HttpMethod.POST, "/auth").permitAll()
            .antMatchers(HttpMethod.PUT,"/auth").permitAll()

            // users
            .antMatchers(HttpMethod.POST, "/users").permitAll()

            // feeds
            .antMatchers(HttpMethod.POST, "/feeds").authenticated()
            .antMatchers(HttpMethod.PUT,"/feeds/{feed_id}").authenticated()
            .antMatchers(HttpMethod.DELETE,"/feeds/{feed_id}").authenticated()
            .antMatchers(HttpMethod.GET,"/feeds").authenticated()

            // comments
            .antMatchers(HttpMethod.POST, "/comments").authenticated()
            .antMatchers(HttpMethod.DELETE,"/comments/{feed_id}").authenticated()



             .anyRequest().denyAll()

            .and()
            .apply(FilterConfig(jwtTokenProvider, jwtTokenResolver, objectMapper))
//            .and()
//            .apply(JwtTokenFilter(jwtTokenResolver, jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java)

    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}