package com.xquare.qkfflgkwk.domain.user.facade

import com.xquare.qkfflgkwk.domain.user.entity.User

sealed interface UserFacade {

    fun findByAccountId(accountId: String): User

    fun saveUser(user: User): User

    fun queryCurrentUser(): User
}