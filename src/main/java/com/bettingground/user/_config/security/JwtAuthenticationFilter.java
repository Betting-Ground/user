package com.bettingground.user._config.security;

import com.bettingground.user._common.exception.ErrorCode;
import com.bettingground.user._common.response.ApiResponse;
import com.bettingground.user._common.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        String accessToken = jwtUtils.getAccessToken(token);

        try {
            if (StringUtils.hasText(accessToken)) {
                AuthDetails authMember = jwtUtils.getAuthUser(accessToken);
                Authentication authentication = new UsernamePasswordAuthenticationToken(authMember,
                    null, authMember.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (JwtException e) {
            sendResponse(response, e);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void sendResponse(HttpServletResponse response, JwtException e) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter()
            .write(objectMapper.writeValueAsString(ApiResponse.fail(ErrorCode.SERVER_ERROR)));
    }
}
