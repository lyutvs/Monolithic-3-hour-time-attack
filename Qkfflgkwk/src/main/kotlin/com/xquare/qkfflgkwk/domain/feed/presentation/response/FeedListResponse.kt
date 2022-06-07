package com.xquare.qkfflgkwk.domain.feed.presentation.response

import java.util.*

class FeedListResponse(
    val responses: List<FeedResponse>
)
class FeedResponse(

    val id: UUID,

    val title: String,

    val content: String

)