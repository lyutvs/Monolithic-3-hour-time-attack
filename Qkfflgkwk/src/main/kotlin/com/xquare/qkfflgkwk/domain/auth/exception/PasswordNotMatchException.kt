package com.xquare.qkfflgkwk.domain.auth.exception

import com.xquare.qkfflgkwk.global.error.CustomException

object PasswordNotMatchException :  CustomException(AuthErrorCode.PASSWORD_MISS_MATCH){
    val EXCEPTION = PasswordNotMatchException
}