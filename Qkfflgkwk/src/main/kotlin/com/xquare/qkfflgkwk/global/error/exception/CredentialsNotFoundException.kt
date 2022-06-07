package com.xquare.qkfflgkwk.global.error.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.error.propertys.CustomExceptionHandlerErrorCode

object CredentialsNotFoundException : CustomException(CustomExceptionHandlerErrorCode.CREDENTIALS_NOT_FOUND){
    val EXCEPTION = CredentialsNotFoundException
}