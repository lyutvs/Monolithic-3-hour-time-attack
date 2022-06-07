package com.xquare.qkfflgkwk.domain.comment.service

import com.xquare.qkfflgkwk.domain.comment.facade.CommentFacade
 import com.xquare.qkfflgkwk.domain.user.entity.type.Authority
import com.xquare.qkfflgkwk.domain.user.facade.UserFacade
import com.xquare.qkfflgkwk.global.error.exception.InvalidRoleException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DeleteCommentService(
    private val userFacade: UserFacade,
    private val commentFacade: CommentFacade
) {

    @Transactional
    fun execute(id: UUID) {
        val user = userFacade.queryCurrentUser()
        val comment = commentFacade.findCommentById(id)

        if (Authority.USER == user.authority && comment.user != user) {
            throw InvalidRoleException.EXCEPTION
        }

        commentFacade.delete(comment)
    }
}
