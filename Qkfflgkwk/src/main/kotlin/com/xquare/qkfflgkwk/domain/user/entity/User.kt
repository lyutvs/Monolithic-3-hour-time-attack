package com.xquare.qkfflgkwk.domain.user.entity

import com.xquare.qkfflgkwk.domain.user.entity.type.Authority
import com.xquare.qkfflgkwk.global.entity.BaseUUIDEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_user")
class User(

    @field:NotNull
    @field:Length(max = 50)
    val accountId: String,

    @field:NotNull
    @field:Length(max = 60)
    val password: String,

    @field:NotNull
    @field:Length(max = 20)
    val name: String,

    authority: Authority

) : BaseUUIDEntity() {

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    var authority: Authority = authority
        protected set

}