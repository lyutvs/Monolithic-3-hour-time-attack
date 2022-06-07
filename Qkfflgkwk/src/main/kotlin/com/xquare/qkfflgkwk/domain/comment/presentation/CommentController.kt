package com.xquare.qkfflgkwk.domain.comment.presentation

import com.xquare.qkfflgkwk.domain.comment.presentation.dto.request.CreateCommentRequest
import com.xquare.qkfflgkwk.domain.comment.service.CreateCommentService
import com.xquare.qkfflgkwk.domain.comment.service.DeleteCommentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/comments")
class CommentController(
    private val createCommentService: CreateCommentService,
    private val deleteCommentService: DeleteCommentService
) {

    @PostMapping
    fun createComment(createCommentRequest: CreateCommentRequest, @PathVariable("feed_id") feedId: UUID) {
        return createCommentService.execute(createCommentRequest, feedId)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{comment_id}")
    fun deleteComment(@PathVariable("commet_id") commentId: UUID) {
        return deleteCommentService.execute(commentId)
    }


}