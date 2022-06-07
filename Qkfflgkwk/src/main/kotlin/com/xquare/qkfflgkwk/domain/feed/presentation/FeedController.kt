package com.xquare.qkfflgkwk.domain.feed.presentation

import com.xquare.qkfflgkwk.domain.feed.presentation.request.CreateFeedRequest
import com.xquare.qkfflgkwk.domain.feed.presentation.request.UpdateFeedRequest
import com.xquare.qkfflgkwk.domain.feed.presentation.response.FeedListResponse
import com.xquare.qkfflgkwk.domain.feed.service.CreateFeedService
import com.xquare.qkfflgkwk.domain.feed.service.DeleteFeedService
import com.xquare.qkfflgkwk.domain.feed.service.FeedListService
import com.xquare.qkfflgkwk.domain.feed.service.UpdateFeedService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/feeds")
class FeedController(
    private val createFeedService: CreateFeedService,
    private val deleteFeedService: DeleteFeedService,
    private val feedListService: FeedListService,
    private val updateFeedService: UpdateFeedService
) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createFeed(@RequestBody @Validated request: CreateFeedRequest) {
        return createFeedService.execute(request)
    }

    @PatchMapping("/{feed_id}")
    fun updateFeed(@PathVariable("feed_id") feedId: UUID, @RequestBody @Validated request: UpdateFeedRequest) {
        return updateFeedService.execute(feedId, request)
    }

    @DeleteMapping("/{feed_id}")
    fun deletePost(@PathVariable("feed_id") feedId: UUID) {
        return deleteFeedService.execute(feedId)
    }

    @GetMapping
    fun getPostList(): FeedListResponse {
        return feedListService.execute()
    }
}