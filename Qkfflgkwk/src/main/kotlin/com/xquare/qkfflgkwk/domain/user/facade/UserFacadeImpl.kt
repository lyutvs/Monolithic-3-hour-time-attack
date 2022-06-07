package com.xquare.qkfflgkwk.domain.user.facade

import com.xquare.qkfflgkwk.domain.user.entity.User
import com.xquare.qkfflgkwk.domain.user.exception.UserNotFoundException
import com.xquare.qkfflgkwk.domain.user.repository.UserRepository
import com.xquare.qkfflgkwk.global.error.exception.CredentialsNotFoundException
import com.xquare.qkfflgkwk.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacadeImpl(
    private val userRepository: UserRepository
) : UserFacade {

    override fun findByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException.EXCEPTION
    }

    override fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    override fun queryCurrentUser(): User {
        val principal = SecurityContextHolder.getContext().authentication.principal as? AuthDetails
            ?: throw CredentialsNotFoundException.EXCEPTION

        return userRepository.findByAccountId((principal as AuthDetails).getUsername())
            ?: throw UserNotFoundException.EXCEPTION
    }

}