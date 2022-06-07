package com.xquare.qkfflgkwk.global.error.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.error.propertys.CustomExceptionHandlerErrorCode

object InternalServerError : CustomException(CustomExceptionHandlerErrorCode.INTERNAL_SERVER) {
    val EXCEPTION = InternalServerError
}