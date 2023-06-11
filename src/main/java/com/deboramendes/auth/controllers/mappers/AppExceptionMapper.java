package com.deboramendes.auth.controllers.mappers;

import com.deboramendes.auth.annotations.Mapper;
import com.deboramendes.auth.controllers.dto.response.AppExceptionResponseDTO;
import com.deboramendes.auth.exceptions.AppException;
import com.deboramendes.auth.interfaces.ToDTOMapper;
import com.deboramendes.auth.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Slf4j
@Mapper
public class AppExceptionMapper implements ToDTOMapper<AppException, AppExceptionResponseDTO> {
    @Override
    public AppExceptionResponseDTO toDTO(final AppException appException) {
        log.trace("m=toDTO(appException)");
        final AppExceptionResponseDTO appExceptionResponseDTO = new AppExceptionResponseDTO();
        appExceptionResponseDTO.setTimestamp(Timestamp.valueOf(appException.getDatetime()));
        appExceptionResponseDTO.setCode(appException.getHttpStatus().value());
        appExceptionResponseDTO.setReason(appException.getType().getMessage());
        appExceptionResponseDTO.setErros(appException.getMessages());
        log.error("m=toDTO(appExceptionResponseDTO={})", JsonUtil.convertObjectToJson(appExceptionResponseDTO));
        return appExceptionResponseDTO;
    }
}