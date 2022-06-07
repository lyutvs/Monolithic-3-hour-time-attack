package com.xquare.qkfflgkwk.domain.auth.presentation

import com.xquare.qkfflgkwk.domain.auth.presentation.dto.request.SignInRequest
import com.xquare.qkfflgkwk.domain.auth.presentation.dto.response.UserTokenRefreshResponse
import com.xquare.qkfflgkwk.domain.auth.service.TokenRefreshService
import com.xquare.qkfflgkwk.domain.auth.service.UserSignInService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userSignInService: UserSignInService,
    private val tokenRefreshService: TokenRefreshService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun signIn(@RequestBody @Valid request: SignInRequest): UserTokenRefreshResponse {
        return userSignInService.execute(request)
    }

    @PutMapping
    fun refreshToken(@RequestHeader("Refresh-Token") refreshToken: String): UserTokenRefreshResponse {
        return tokenRefreshService.execute(refreshToken)
    }
}