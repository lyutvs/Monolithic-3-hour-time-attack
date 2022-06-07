package com.xquare.qkfflgkwk.global.security.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.security.jwt.exception.JwtErrorCode

object ExpiredTokenException : CustomException(JwtErrorCode.JWT_EXPIRED) {
    val EXCEPTION = ExpiredTokenException
}