package com.xquare.qkfflgkwk.domain.feed.exception

import com.xquare.qkfflgkwk.global.error.propertys.ExceptionProperty

enum class FeedErrorCode(
    override val errorMessage: String,
    override val status: Int
) : ExceptionProperty {
    FEED_NOT_FOUND("Feed Not Found", 404)
}