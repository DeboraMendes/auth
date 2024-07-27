package com.deboramendes.auth.configurations.filters;

import com.deboramendes.auth.services.jwt.JWTExtractorService;
import com.deboramendes.auth.services.jwt.JWTValidatorService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    public static final String AUTH_HEADER = "Authorization";
    public static final String AUTH_PREFIX = "Bearer ";

    private final JWTExtractorService jwtExtractorService;
    private final UserDetailsService userDetailsService;
    private final JWTValidatorService jwtValidatorService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        StopWatch sw = new StopWatch();

        sw.start();

        log.info(String.format("[REQUEST][%s]: %s", request.getMethod(), request.getRequestURI()));

        Optional.ofNullable(request.getHeader(AUTH_HEADER))
                .filter(authValue -> authValue.startsWith(AUTH_PREFIX))
                .ifPresent(authValue -> extracted(request, authValue));

        filterChain.doFilter(request, response);

        sw.stop();

        log.info(String.format("[RESPONSE][%d][%s][%dms]: %s", response.getStatus(), request.getMethod(), sw.getTotalTimeMillis(), request.getRequestURI()));
    }

    private void extracted(HttpServletRequest request, String authValue) {
        final String token = authValue.replace(AUTH_PREFIX, "");
        Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .flatMap(authentication -> Optional.ofNullable(jwtExtractorService.extractUsername(token)))
                .ifPresent(username -> {
                    final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (jwtValidatorService.isTokenValid(token, userDetails)) {
                        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                        authenticationToken.setDetails(
                                new WebAuthenticationDetailsSource().buildDetails(request)
                        );

                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }

                });
    }
}
