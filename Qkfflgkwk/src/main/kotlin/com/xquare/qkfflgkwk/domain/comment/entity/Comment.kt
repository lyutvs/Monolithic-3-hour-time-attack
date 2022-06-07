package com.xquare.qkfflgkwk.domain.comment.entity

import com.xquare.qkfflgkwk.domain.feed.entity.Feed
import com.xquare.qkfflgkwk.domain.user.entity.User
import com.xquare.qkfflgkwk.global.entity.BaseUUIDEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_comment")
class Comment(

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @field:NotNull
    @field:Length(max = 165)
    val content: String,

    @field:NotNull
    @field:Length(max = 50)
    val title: String,

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "feed_id", nullable = false)
    val feed: Feed,

    ) : BaseUUIDEntity()