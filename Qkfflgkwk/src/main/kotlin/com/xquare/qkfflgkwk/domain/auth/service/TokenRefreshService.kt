package com.xquare.qkfflgkwk.domain.auth.service

import com.xquare.qkfflgkwk.domain.auth.entity.RefreshToken
import com.xquare.qkfflgkwk.domain.auth.facade.AuthFacade
import com.xquare.qkfflgkwk.domain.auth.presentation.dto.response.UserTokenRefreshResponse
import com.xquare.qkfflgkwk.global.security.jwt.JwtTokenProvider
import com.xquare.qkfflgkwk.global.security.jwt.JwtTokenResolver
import com.xquare.qkfflgkwk.global.security.properties.JwtProperty
import org.springframework.stereotype.Service

@Service
class TokenRefreshService(
    private val authFacade: AuthFacade,
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtTokenResolver: JwtTokenResolver

) {

    fun execute(refreshToken: String): UserTokenRefreshResponse {
        val redisRefreshToken = authFacade.findByToken(jwtTokenResolver.parseToken(refreshToken)) as RefreshToken

        val newRefreshToken = jwtTokenProvider.generateRefreshToken(redisRefreshToken.accountId)
        val accessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.accountId)
        val expiredTime = jwtTokenProvider.getExpiredTime()

        return UserTokenRefreshResponse(
            accessToken = accessToken,
            refreshToken = newRefreshToken,
            expiredAt = expiredTime
        )
    }
}