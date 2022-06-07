package com.xquare.qkfflgkwk.domain.user.presentation

import com.xquare.qkfflgkwk.domain.user.presentation.dto.request.SignUpRequest
import com.xquare.qkfflgkwk.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val userService: UserService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@Valid @RequestBody request: SignUpRequest) {
        return userService.execute(request)
    }
}
