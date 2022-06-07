package com.xquare.qkfflgkwk.global.security.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.security.jwt.exception.JwtErrorCode


object SignatureTokenException : CustomException(JwtErrorCode.JWT_SIGNATURE) {
    val EXCEPTION = SignatureTokenException
}