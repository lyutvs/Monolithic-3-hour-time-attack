package com.xquare.qkfflgkwk.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class SignUpRequest {

    @field:NotBlank
    lateinit var accountId: String
        private set

    @field:NotBlank
    lateinit var name: String
        private set

    @field:Size(min = 6, max = 20)
    @field:NotBlank
    lateinit var password: String
        private set
}