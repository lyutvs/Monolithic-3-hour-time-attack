package com.xquare.qkfflgkwk.global.error.exception

import com.xquare.qkfflgkwk.global.error.CustomException
import com.xquare.qkfflgkwk.global.error.propertys.CustomExceptionHandlerErrorCode

object InvalidRoleException : CustomException(CustomExceptionHandlerErrorCode.INVALID_ROLE) {
    val EXCEPTION = InvalidRoleException
}