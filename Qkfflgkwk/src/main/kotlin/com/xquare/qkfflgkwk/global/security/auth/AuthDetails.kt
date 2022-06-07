package com.xquare.qkfflgkwk.global.security.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import com.xquare.qkfflgkwk.domain.user.entity.User

class AuthDetails (
    private val user: User
) : UserDetails {

    private val authorities: MutableList<SimpleGrantedAuthority> = mutableListOf()

    init {
        this.authorities += SimpleGrantedAuthority(user.authority.toString())
    }

    override fun getAuthorities(): List<GrantedAuthority> = this.authorities

    override fun getPassword() = user.password

    override fun getUsername() = user.accountId

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}