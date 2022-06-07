package com.xquare.qkfflgkwk.global.error.propertys

enum class CustomExceptionHandlerErrorCode(
    override val errorMessage: String,
    override val status: Int
) : ExceptionProperty {
    INVALID_METHOD_ARGUMENT("Invalid Method Argument", 400),
    REQUEST_NOT_FOUND("Cannot Find Valid Controller", 404),
    INTERNAL_SERVER("Internal Server Error", 500),
    CREDENTIALS_NOT_FOUND("Credentials Not Found", 404),
    INVALID_ROLE( "Invalid Role",401)

}

