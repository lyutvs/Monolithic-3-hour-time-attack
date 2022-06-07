package com.xquare.qkfflgkwk.domain.feed.service

import com.xquare.qkfflgkwk.domain.feed.entity.Feed
import com.xquare.qkfflgkwk.domain.feed.facade.FeedFacade
import com.xquare.qkfflgkwk.domain.feed.presentation.request.CreateFeedRequest
import com.xquare.qkfflgkwk.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CreateFeedService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade
) {

    @Transactional
    fun execute(request: CreateFeedRequest) {
        val user = userFacade.queryCurrentUser()

        val feed = Feed(
            user = user,
            title = request.title,
            content = request.content
        )

        feedFacade.save(feed)
    }
}