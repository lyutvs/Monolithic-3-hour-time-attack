package com.xquare.qkfflgkwk.domain.comment.presentation.dto.request

import java.util.*
import javax.validation.constraints.NotBlank

class CreateCommentRequest{
    @field:NotBlank
    lateinit var feedId: UUID
        private set

    @field:NotBlank
    lateinit var title: String
    private set

    @field:NotBlank
    lateinit var content: String
    private set
}