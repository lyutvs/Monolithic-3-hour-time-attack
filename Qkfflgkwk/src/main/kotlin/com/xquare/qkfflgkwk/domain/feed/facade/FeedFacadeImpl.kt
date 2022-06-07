package com.xquare.qkfflgkwk.domain.feed.facade

import com.xquare.qkfflgkwk.domain.feed.entity.Feed
import com.xquare.qkfflgkwk.domain.feed.exception.FeedNotFoundException
import com.xquare.qkfflgkwk.domain.feed.repository.FeedRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class FeedFacadeImpl(
    private val feedRepository: FeedRepository
) : FeedFacade {

    override fun save(feed: Feed): Feed {
        return feedRepository.save(feed)
    }

    override fun findFeedById(id: UUID): Feed {
        return feedRepository.findByIdOrNull(id) ?: throw FeedNotFoundException.EXCEPTION
    }

    override fun delete(feed: Feed) {
        return feedRepository.delete(feed)
    }

    override fun findAllByFeed(): List<Feed> {
        return feedRepository.findAll() as List<Feed>
    }

}