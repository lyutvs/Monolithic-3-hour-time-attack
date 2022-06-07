package com.xquare.qkfflgkwk.domain.user.exception

import com.xquare.qkfflgkwk.global.error.propertys.ExceptionProperty

enum class UserErrorCode(
    override val errorMessage: String,
    override val status: Int
) : ExceptionProperty {
    USER_NOT_FOUND( "User Not Found",404)
}