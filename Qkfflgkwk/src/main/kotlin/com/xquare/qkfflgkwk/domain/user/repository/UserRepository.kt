package com.xquare.qkfflgkwk.domain.user.repository

import com.xquare.qkfflgkwk.domain.user.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, UUID>{
    fun findByAccountId(accountId: String): User?
}