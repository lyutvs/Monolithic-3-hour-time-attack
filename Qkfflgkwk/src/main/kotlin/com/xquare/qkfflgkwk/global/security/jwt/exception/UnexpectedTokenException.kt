package com.xquare.qkfflgkwk.global.security.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.security.jwt.exception.JwtErrorCode

object UnexpectedTokenException : CustomException(JwtErrorCode.UNEXPECTED_TOKEN) {
    val EXCEPTION = UnexpectedTokenException
}