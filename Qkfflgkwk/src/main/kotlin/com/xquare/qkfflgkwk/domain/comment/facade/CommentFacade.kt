package com.xquare.qkfflgkwk.domain.comment.facade

import com.xquare.qkfflgkwk.domain.comment.entity.Comment
import java.util.*

sealed interface CommentFacade {
     fun save(comment: Comment): Comment

     fun findCommentById(id: UUID): Comment

     fun delete(comment: Comment)
}