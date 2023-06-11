package com.deboramendes.auth.controllers.mappers;

import com.deboramendes.auth.annotations.Mapper;
import com.deboramendes.auth.controllers.dto.response.UserAuthenticationResponseDTO;
import com.deboramendes.auth.interfaces.ToDTOMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Mapper
public class UserAuthenticationMapper implements ToDTOMapper<String, UserAuthenticationResponseDTO> {
    @Override
    public UserAuthenticationResponseDTO toDTO(final String token) {
        log.trace("m=toDTO(token)");
        final UserAuthenticationResponseDTO userAuthenticationResponseDTO = new UserAuthenticationResponseDTO();
        userAuthenticationResponseDTO.setToken(token);
        return userAuthenticationResponseDTO;
    }
}
