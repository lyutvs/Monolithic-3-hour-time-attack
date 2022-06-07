package com.xquare.qkfflgkwk.global.security.jwt

import com.xquare.qkfflgkwk.domain.auth.entity.RefreshToken
import com.xquare.qkfflgkwk.domain.auth.facade.AuthFacade
import com.xquare.qkfflgkwk.global.security.auth.AuthDetailsService
import com.xquare.qkfflgkwk.global.security.exception.ExpiredTokenException
import com.xquare.qkfflgkwk.global.security.exception.JwtValidateException
import com.xquare.qkfflgkwk.global.security.exception.SignatureTokenException
import com.xquare.qkfflgkwk.global.security.exception.UnexpectedTokenException
import com.xquare.qkfflgkwk.global.security.properties.JwtProperty
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtTokenProvider(
    private val authDetailsService: AuthDetailsService,
    private val jwtProperty: JwtProperty,
    private val authFacade: AuthFacade
) {

    companion object {
        private const val ACCESS_KEY = "access"
        private const val REFRESH_KEY = "refresh"
    }

    fun generateRefreshToken(accountId: String): String {
        val newRefreshToken: String = generateToken(accountId, jwtProperty.accessExp, REFRESH_KEY)
        authFacade.save(RefreshToken(
            accountId = (accountId),
            token = newRefreshToken
        ))
        return newRefreshToken
    }

    fun generateAccessToken(accountId: String): String {
        return generateToken(accountId, jwtProperty.accessExp, ACCESS_KEY)
    }

    private fun generateToken(accountId: String, expiration: Long, type: String): String {
        return "Bearer " + Jwts.builder()
            .setSubject(accountId)
            .setIssuedAt(Date())
            .signWith(SignatureAlgorithm.HS512, jwtProperty.secretKey)
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
            .setHeaderParam("typ", type)
            .compact()
    }


    fun getAuthentication(token: String?): Authentication? {
        return token?.let {
            val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))

            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    private fun getTokenSubject(subject: String): String {
        return parseTokenBody(subject).subject
    }

    private fun parseTokenBody(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperty.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException.EXCEPTION
                is SignatureException -> throw SignatureTokenException.EXCEPTION
                is MalformedJwtException -> throw JwtValidateException.EXCEPTION
                else -> throw UnexpectedTokenException.EXCEPTION
            }
        }
    }

    fun getExpiredTime(): LocalDateTime? {
        return LocalDateTime.now().plusSeconds(jwtProperty.refreshExp)
    }
}