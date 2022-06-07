package com.xquare.qkfflgkwk.domain.auth.presentation.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class UserTokenRefreshResponse(

    val accessToken: String,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val expiredAt: LocalDateTime?,

    val refreshToken: String
)