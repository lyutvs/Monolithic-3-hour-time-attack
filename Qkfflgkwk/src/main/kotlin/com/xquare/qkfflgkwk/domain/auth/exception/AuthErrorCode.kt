package com.xquare.qkfflgkwk.domain.auth.exception

import com.xquare.qkfflgkwk.global.error.propertys.ExceptionProperty

enum class AuthErrorCode(
    override val errorMessage: String,
    override val status: Int
) : ExceptionProperty {

    REFRESH_TOKEN_NOT_FOUND("Refresh Token Not Found", 404),
    PASSWORD_MISS_MATCH("Password Miss Match", 401)

}