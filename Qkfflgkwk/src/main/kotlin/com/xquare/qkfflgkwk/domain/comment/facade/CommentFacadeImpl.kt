package com.xquare.qkfflgkwk.domain.comment.facade

import com.xquare.qkfflgkwk.domain.comment.entity.Comment
import com.xquare.qkfflgkwk.domain.comment.exception.CommentNotFoundException
import com.xquare.qkfflgkwk.domain.comment.repository.CommentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class CommentFacadeImpl(
    private val commentRepository: CommentRepository
) : CommentFacade {

    override fun save(comment: Comment): Comment {
        return commentRepository.save(comment)
    }

    override fun findCommentById(id: UUID): Comment {
        return commentRepository.findByIdOrNull(id) ?: throw CommentNotFoundException.EXCEPTION
    }

    override fun delete(comment: Comment) {
        return commentRepository.delete(comment)
    }

}