package com.xquare.qkfflgkwk.global.security.jwt.exception

import com.xquare.qkfflgkwk.global.error.propertys.ExceptionProperty


enum class JwtErrorCode(

    override val status: Int,
    override val errorMessage: String

) : ExceptionProperty {

    JWT_VALIDATE_FAIL(401, "Token Validate Failed"),
    JWT_EXPIRED(401, "Jwt Token Expired"),
    JWT_SIGNATURE(401, "Invalid Signature"),
    UNEXPECTED_TOKEN(500, "Unexpected Token Exception")
}