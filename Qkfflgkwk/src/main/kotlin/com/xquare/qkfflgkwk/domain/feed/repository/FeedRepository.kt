package com.xquare.qkfflgkwk.domain.feed.repository

import com.xquare.qkfflgkwk.domain.feed.entity.Feed
import org.springframework.data.repository.CrudRepository
import java.util.*

interface FeedRepository : CrudRepository<Feed, UUID> {
}