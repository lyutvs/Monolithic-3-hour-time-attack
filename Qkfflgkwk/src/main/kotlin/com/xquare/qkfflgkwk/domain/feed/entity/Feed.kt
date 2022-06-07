package com.xquare.qkfflgkwk.domain.feed.entity

import com.xquare.qkfflgkwk.domain.user.entity.User
import com.xquare.qkfflgkwk.global.entity.BaseUUIDEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_feed")
class Feed(

    @field:NotNull
    @field:Length(max = 30)
    var title: String,

    @field:NotNull
    @field:Length(max = 165)
    var content: String,

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "user_id", nullable = false)
    val user: User

) : BaseUUIDEntity() {

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }

}
