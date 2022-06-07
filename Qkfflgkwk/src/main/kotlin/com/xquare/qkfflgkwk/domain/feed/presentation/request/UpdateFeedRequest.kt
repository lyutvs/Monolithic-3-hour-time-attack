package com.xquare.qkfflgkwk.domain.feed.presentation.request

import javax.validation.constraints.NotBlank

class UpdateFeedRequest{
    @field:NotBlank
    lateinit var title: String
        private set

    @field:NotBlank
    lateinit var content: String
        private set
}