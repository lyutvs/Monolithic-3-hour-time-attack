package com.xquare.qkfflgkwk.domain.comment.service

import com.xquare.qkfflgkwk.domain.comment.entity.Comment
import com.xquare.qkfflgkwk.domain.comment.facade.CommentFacade
import com.xquare.qkfflgkwk.domain.comment.presentation.dto.request.CreateCommentRequest
import com.xquare.qkfflgkwk.domain.feed.facade.FeedFacade
import com.xquare.qkfflgkwk.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CreateCommentService(
    private val commentFacade: CommentFacade,
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade
) {

    @Transactional
    fun execute(request: CreateCommentRequest, feedId: UUID) {
        val  user = userFacade.queryCurrentUser();
        val feed = feedFacade.findFeedById(feedId)

        val comment = Comment(
            user = user,
            content = request.content,
            title = request.title,
            feed = feed
        )
        commentFacade.save(comment)

    }
}