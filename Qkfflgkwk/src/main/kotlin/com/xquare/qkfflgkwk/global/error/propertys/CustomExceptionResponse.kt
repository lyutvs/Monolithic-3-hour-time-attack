package com.xquare.qkfflgkwk.global.error.propertys

import com.fasterxml.jackson.annotation.JsonInclude
import com.xquare.qkfflgkwk.global.error.CustomException

class CustomExceptionResponse<T> (
    val status: Int,
    val message: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val content: T?
) {

    companion object {
        fun of(exception: CustomException): CustomExceptionResponse<Unit> {
            return CustomExceptionResponse(
                status = exception.status,
                message = exception.errorMessage,
                content = null
            )
        }
    }

}