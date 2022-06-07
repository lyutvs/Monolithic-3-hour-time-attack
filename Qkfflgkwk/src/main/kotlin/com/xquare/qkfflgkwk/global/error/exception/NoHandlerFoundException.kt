package com.xquare.qkfflgkwk.global.error.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.error.propertys.CustomExceptionHandlerErrorCode

object NoHandlerFoundException : CustomException(CustomExceptionHandlerErrorCode.REQUEST_NOT_FOUND){
    val EXCEPTION = NoHandlerFoundException
}