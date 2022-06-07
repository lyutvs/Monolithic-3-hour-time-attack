package com.xquare.qkfflgkwk.domain.comment.repository

import com.xquare.qkfflgkwk.domain.comment.entity.Comment
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CommentRepository : CrudRepository<Comment, UUID> {
}