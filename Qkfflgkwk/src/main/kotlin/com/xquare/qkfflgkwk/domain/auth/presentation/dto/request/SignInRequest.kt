package com.xquare.qkfflgkwk.domain.auth.presentation.dto.request

import javax.validation.constraints.NotBlank

class SignInRequest {
    @field:NotBlank
    lateinit var accountId: String
        private set

    @field:NotBlank
    lateinit var password: String
        private set
}