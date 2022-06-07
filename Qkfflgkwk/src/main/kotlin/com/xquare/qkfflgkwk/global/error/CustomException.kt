package com.xquare.qkfflgkwk.global.error

import com.xquare.qkfflgkwk.global.error.propertys.ExceptionProperty

open class CustomException(private val property: ExceptionProperty): RuntimeException() {
    val status: Int
        get() = property.status

    val errorMessage
        get() = property.errorMessage
}