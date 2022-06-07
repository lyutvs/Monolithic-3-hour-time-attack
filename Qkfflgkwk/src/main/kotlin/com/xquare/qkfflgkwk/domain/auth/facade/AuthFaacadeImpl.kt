package com.xquare.qkfflgkwk.domain.auth.facade

import com.xquare.qkfflgkwk.domain.auth.entity.RefreshToken
import com.xquare.qkfflgkwk.domain.auth.exception.RefreshTokenNotFoundException
import com.xquare.qkfflgkwk.domain.auth.repository.RefreshTokenRepository
import org.springframework.stereotype.Component

@Component
class AuthFacadeImpl(
    private val refreshTokenRepository: RefreshTokenRepository
) : AuthFacade{

    override fun findByToken(token: String) {
        return refreshTokenRepository.findByToken(token) ?: throw RefreshTokenNotFoundException.EXCEPTION
    }

    override fun save(token: RefreshToken): RefreshToken {
        return refreshTokenRepository.save(token)
    }

}