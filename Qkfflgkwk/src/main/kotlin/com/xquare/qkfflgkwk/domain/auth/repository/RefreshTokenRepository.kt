package com.xquare.qkfflgkwk.domain.auth.repository

import com.xquare.qkfflgkwk.domain.auth.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {
    fun findByToken(token: String)
}