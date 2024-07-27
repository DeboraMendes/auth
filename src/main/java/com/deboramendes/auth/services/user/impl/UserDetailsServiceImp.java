package com.deboramendes.auth.services.user.impl;

import com.deboramendes.auth.exceptions.AppExceptionGenerator;
import com.deboramendes.auth.repositories.UserRepository;
import com.deboramendes.auth.services.domains.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        log.trace("m=loadUserByUsername(username={})", username);
        return userRepository.findByUsername(username)
                .map(User::new)
                .orElseThrow(() -> AppExceptionGenerator.generateUserAuthenticationException("Unregistered user"));
    }
}
