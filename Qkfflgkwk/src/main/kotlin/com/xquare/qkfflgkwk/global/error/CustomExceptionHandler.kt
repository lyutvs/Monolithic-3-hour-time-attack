package com.xquare.qkfflgkwk.global.error

import com.xquare.qkfflgkwk.global.error.exception.InvalidMethodArgumentException
import com.xquare.qkfflgkwk.global.error.exception.NoHandlerFoundException
import com.xquare.qkfflgkwk.global.error.exception.RequestNotFoundException
import com.xquare.qkfflgkwk.global.error.propertys.CustomExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentValid(): ResponseEntity<CustomExceptionResponse<Unit>> {
        return handleException(InvalidMethodArgumentException.EXCEPTION)
    }

    @ExceptionHandler(NoHandlerFoundException::class)
    fun notFound(): ResponseEntity<CustomExceptionResponse<Unit>> {
        return handleException(RequestNotFoundException.EXCEPTION)
    }

    @ExceptionHandler(CustomException::class)
    fun globalException(e: CustomException): ResponseEntity<CustomExceptionResponse<Unit>> {
        return handleException(e)
    }

    private fun handleException(e: CustomException): ResponseEntity<CustomExceptionResponse<Unit>> {
        val httpStatus = HttpStatus.valueOf(e.status)
        val body = CustomExceptionResponse.of(e)
        return ResponseEntity(body, httpStatus)
    }

    @ExceptionHandler(BindException::class)
    fun bindException(e: BindException): ResponseEntity<*>? {
        val errorMap: MutableMap<String, String?> = HashMap()
        for (error in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity<Map<String, String?>>(errorMap, HttpStatus.BAD_REQUEST)
    }

}