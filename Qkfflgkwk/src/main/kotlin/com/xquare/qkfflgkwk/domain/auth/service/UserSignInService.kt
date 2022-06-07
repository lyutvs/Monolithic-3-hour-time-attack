package com.xquare.qkfflgkwk.domain.auth.service

import com.xquare.qkfflgkwk.domain.auth.exception.PasswordNotMatchException
import com.xquare.qkfflgkwk.domain.auth.presentation.dto.request.SignInRequest
import com.xquare.qkfflgkwk.domain.auth.presentation.dto.response.UserTokenRefreshResponse
import com.xquare.qkfflgkwk.domain.user.entity.User
import com.xquare.qkfflgkwk.domain.user.facade.UserFacade
import com.xquare.qkfflgkwk.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserSignInService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun execute(request: SignInRequest): UserTokenRefreshResponse {
        val user = userFacade.findByAccountId(request.accountId) as User

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordNotMatchException.EXCEPTION
        }


        val accessToken = jwtTokenProvider.generateAccessToken(user.accountId)
        val refreshToken = jwtTokenProvider.generateRefreshToken(user.accountId)

        return UserTokenRefreshResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiredAt = jwtTokenProvider.getExpiredTime()
        )
    }
}
