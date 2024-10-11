package com.bettingground.user._common.utils;

import com.bettingground.user._config.security.AuthDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JwtUtils {

    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.expiration-time}")
    private Long expirationTime;
    private Key key;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(AuthDetails authDetails) {
        Date issueAt = new Date();
        Date expiredAt = new Date(issueAt.getTime() + expirationTime);
        return Jwts.builder()
            .claim("userToken", authDetails.getUserToken())
            .setIssuedAt(issueAt)
            .setExpiration(expiredAt)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public String getAccessToken(String token) {
        String accessToken = null;
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            accessToken = token.replace("Bearer ", "");
        }
        return accessToken;
    }

    public AuthDetails getAuthUser(String accessToken) {
        Claims claims = validateAccessToken(accessToken);
        return AuthDetails.of(claims);
    }

    public Claims validateAccessToken(String accessToken) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(accessToken)
            .getBody();
    }

}
