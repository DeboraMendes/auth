package com.deboramendes.auth.controllers.mappers;

import com.deboramendes.auth.annotations.Mapper;
import com.deboramendes.auth.controllers.dto.response.UserCreationResponseDTO;
import com.deboramendes.auth.interfaces.ToDTOMapper;
import com.deboramendes.auth.repositories.entities.user.UserEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Mapper
public class UserCreationMapper implements ToDTOMapper<UserEntity, UserCreationResponseDTO> {
    @Override
    public UserCreationResponseDTO toDTO(final UserEntity userEntity) {
        log.trace("m=toDTO(userEntity)");
        final UserCreationResponseDTO userCreationResponseDTO = new UserCreationResponseDTO();
        userCreationResponseDTO.setId(userEntity.getId());
        return userCreationResponseDTO;
    }
}
