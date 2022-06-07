package com.xquare.qkfflgkwk.global.security.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.security.jwt.exception.JwtErrorCode


object JwtValidateException : CustomException(JwtErrorCode.JWT_VALIDATE_FAIL) {
    val EXCEPTION = JwtValidateException
}