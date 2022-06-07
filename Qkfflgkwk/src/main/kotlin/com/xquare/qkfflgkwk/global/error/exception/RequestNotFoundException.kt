package com.xquare.qkfflgkwk.global.error.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.error.propertys.CustomExceptionHandlerErrorCode

object RequestNotFoundException : CustomException(CustomExceptionHandlerErrorCode.REQUEST_NOT_FOUND) {

    val EXCEPTION = RequestNotFoundException

}