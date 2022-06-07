package com.xquare.qkfflgkwk.domain.feed.service

import com.xquare.qkfflgkwk.domain.feed.facade.FeedFacade
import com.xquare.qkfflgkwk.domain.feed.presentation.request.UpdateFeedRequest
import com.xquare.qkfflgkwk.domain.user.entity.type.Authority
import com.xquare.qkfflgkwk.domain.user.facade.UserFacade
import com.xquare.qkfflgkwk.global.error.exception.InvalidRoleException
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class UpdateFeedService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade

) {

    @Transactional
    fun execute(id: UUID, request: UpdateFeedRequest) {
        val user = userFacade.queryCurrentUser()
        val feed = feedFacade.findFeedById(id)

        if (Authority.USER == user.authority && feed.user != user) {
            throw InvalidRoleException.EXCEPTION
        }

        feed.update(
            title = request.title,
            content = request.content
        )

    }
}