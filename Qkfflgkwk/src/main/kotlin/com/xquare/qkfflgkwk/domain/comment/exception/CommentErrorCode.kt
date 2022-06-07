package com.xquare.qkfflgkwk.domain.comment.exception

import com.xquare.qkfflgkwk.global.error.propertys.ExceptionProperty

enum class CommentErrorCode(
    override val errorMessage: String,
    override val status: Int
) : ExceptionProperty {
    COMMENT_NOT_FOUND("Comment Not Found", 404)
}
