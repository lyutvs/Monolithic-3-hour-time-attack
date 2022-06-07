package com.xquare.qkfflgkwk.domain.auth.facade

import com.xquare.qkfflgkwk.domain.auth.entity.RefreshToken

sealed interface AuthFacade {
    fun findByToken(token: String)

    fun save(token: RefreshToken): RefreshToken

}