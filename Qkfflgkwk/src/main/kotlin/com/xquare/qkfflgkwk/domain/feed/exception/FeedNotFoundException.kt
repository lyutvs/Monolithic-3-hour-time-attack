package com.xquare.qkfflgkwk.domain.feed.exception

import com.xquare.qkfflgkwk.global.error.CustomException

object FeedNotFoundException : CustomException(FeedErrorCode.FEED_NOT_FOUND) {
    val EXCEPTION = FeedNotFoundException
}