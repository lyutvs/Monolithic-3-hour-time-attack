package com.xquare.qkfflgkwk.domain.feed.facade

import com.xquare.qkfflgkwk.domain.feed.entity.Feed
import java.util.*

sealed interface FeedFacade {
    fun save(feed: Feed): Feed

    fun findFeedById(id: UUID): Feed

    fun delete(feed: Feed)

    fun findAllByFeed(): List<Feed>
}