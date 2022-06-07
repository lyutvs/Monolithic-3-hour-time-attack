package com.xquare.qkfflgkwk.domain.feed.service

import com.xquare.qkfflgkwk.domain.feed.facade.FeedFacade
import com.xquare.qkfflgkwk.domain.feed.presentation.response.FeedListResponse
import com.xquare.qkfflgkwk.domain.feed.presentation.response.FeedResponse
import com.xquare.qkfflgkwk.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class FeedListService(
    private val feedFacade: FeedFacade
) {

    @Transactional(readOnly = true)
    fun execute(): FeedListResponse {
        val feed = feedFacade.findAllByFeed()

        val list: List<FeedResponse> = feed
            .map {
                FeedResponse(
                    id = it.id,
                    title = it.title,
                    content = it.content
                )
            }
            .toList()

        return FeedListResponse(
            responses = list
        )
    }
}
