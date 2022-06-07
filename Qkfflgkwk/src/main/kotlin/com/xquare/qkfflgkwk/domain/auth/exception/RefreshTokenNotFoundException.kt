package com.xquare.qkfflgkwk.domain.auth.exception

import com.xquare.qkfflgkwk.global.error.CustomException

object RefreshTokenNotFoundException : CustomException(AuthErrorCode.REFRESH_TOKEN_NOT_FOUND) {
    val EXCEPTION = RefreshTokenNotFoundException
}