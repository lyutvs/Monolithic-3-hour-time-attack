package com.xquare.qkfflgkwk.domain.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import javax.validation.constraints.NotBlank

@RedisHash(value = "RefreshToken", timeToLive = 60 * 60 * 2)
class RefreshToken(

    @Id
    val accountId: String,

    @Indexed
    @NotBlank
    val token: String

)