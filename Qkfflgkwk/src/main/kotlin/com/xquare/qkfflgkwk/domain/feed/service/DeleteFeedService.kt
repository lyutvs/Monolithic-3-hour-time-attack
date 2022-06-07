package com.xquare.qkfflgkwk.domain.feed.service

import com.xquare.qkfflgkwk.domain.feed.facade.FeedFacade
import com.xquare.qkfflgkwk.domain.user.entity.type.Authority
import com.xquare.qkfflgkwk.domain.user.facade.UserFacade
import com.xquare.qkfflgkwk.global.error.exception.InvalidRoleException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DeleteFeedService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade
) {

    @Transactional
    fun execute(id: UUID) {
        val user = userFacade.queryCurrentUser()
        val feed = feedFacade.findFeedById(id)

        if (Authority.USER == user.authority && feed.user != user) {
            throw InvalidRoleException.EXCEPTION
        }

        feedFacade.delete(feed)

    }
}