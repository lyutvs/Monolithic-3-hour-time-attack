package com.xquare.qkfflgkwk.domain.comment.exception

import com.xquare.qkfflgkwk.global.error.CustomException

object CommentNotFoundException : CustomException(CommentErrorCode.COMMENT_NOT_FOUND){
    val EXCEPTION = CommentNotFoundException
}