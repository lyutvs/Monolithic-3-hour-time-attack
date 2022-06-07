package com.xquare.qkfflgkwk.global.error.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.error.propertys.CustomExceptionHandlerErrorCode


object InvalidMethodArgumentException : CustomException(CustomExceptionHandlerErrorCode.INVALID_METHOD_ARGUMENT){
    val EXCEPTION = InvalidMethodArgumentException
}