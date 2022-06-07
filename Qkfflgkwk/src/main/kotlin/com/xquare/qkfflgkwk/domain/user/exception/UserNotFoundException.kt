package com.xquare.qkfflgkwk.domain.user.exception

import com.xquare.qkfflgkwk.global.error.CustomException

object UserNotFoundException : CustomException(UserErrorCode.USER_NOT_FOUND) {
    val EXCEPTION = UserNotFoundException
}