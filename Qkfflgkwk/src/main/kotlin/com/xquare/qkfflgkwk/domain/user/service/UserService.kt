package com.xquare.qkfflgkwk.domain.user.service

import com.xquare.qkfflgkwk.domain.user.entity.User
import com.xquare.qkfflgkwk.domain.user.entity.type.Authority
import com.xquare.qkfflgkwk.domain.user.facade.UserFacade
import com.xquare.qkfflgkwk.domain.user.presentation.dto.request.SignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun execute(request: SignUpRequest) {
        val user = User(
            name = request.name,
            accountId = request.accountId,
            password = passwordEncoder.encode(request.password),
            authority = Authority.USER
        )

        userFacade.saveUser(user)
    }

}
