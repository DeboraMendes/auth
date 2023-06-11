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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    public static final String AUTH_HEADER_FIELD = "Authorization";
    public static final String AUTH_FIELD_PREFIX = "Bearer ";

    private final JWTExtractorService jwtExtractorService;
    private final UserDetailsService userDetailsService;
    private final JWTValidatorService jwtValidatorService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        log.debug("m=doFilterInternal(request, response, filterChain)");

        log.debug("m=doFilterInternal(method={},URL={})", request.getMethod(), request.getRequestURL());

        final Optional<String> header = Optional.ofNullable(request.getHeader(AUTH_HEADER_FIELD));

        final boolean isHeaderValid = header.map(value -> value.startsWith(AUTH_FIELD_PREFIX)).orElse(Boolean.FALSE);

        log.debug("m=doFilterInternal(isHeaderValid={})", isHeaderValid);

        if (!isHeaderValid) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = header.map(value -> value.replace(AUTH_FIELD_PREFIX, "")).orElse("");

        final Optional<String> username = Optional.ofNullable(jwtExtractorService.extractUsername(token));

        log.debug("m=doFilterInternal(username={})", username);

        final Optional<Authentication> authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());

        if (username.isPresent() && authentication.isPresent()) {

            final UserDetails userDetails = userDetailsService.loadUserByUsername(username.get());

            final boolean isTokenValid = jwtValidatorService.isTokenValid(token, userDetails);

            log.debug("m=doFilterInternal(isTokenValid={})", isTokenValid);

            if (isTokenValid) {
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
        }

        filterChain.doFilter(request, response);
    }
}
