package com.deboramendes.auth.controllers.v1;

import com.deboramendes.auth.controllers.dto.request.UserRequestDTO;
import com.deboramendes.auth.controllers.dto.response.AppExceptionResponseDTO;
import com.deboramendes.auth.controllers.dto.response.UserAuthenticationResponseDTO;
import com.deboramendes.auth.controllers.dto.response.UserCreationResponseDTO;
import com.deboramendes.auth.exceptions.BusinessException;
import com.deboramendes.auth.exceptions.UserAuthenticationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "User", description = "User APIs")
public interface UserController {

    @Operation(summary = "User creation")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User created", content = {@Content(schema = @Schema(implementation = UserCreationResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data", content = {@Content(schema = @Schema(implementation = AppExceptionResponseDTO.class))}),
            @ApiResponse(responseCode = "406", description = "User already exists", content = {@Content(schema = @Schema(implementation = AppExceptionResponseDTO.class))}),
    })
    ResponseEntity<UserCreationResponseDTO> createUser(final UserRequestDTO userRequestDTO) throws BusinessException;

    @Operation(summary = "User authentication")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Token generated", content = {@Content(schema = @Schema(implementation = UserAuthenticationResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data", content = {@Content(schema = @Schema(implementation = AppExceptionResponseDTO.class))}),
            @ApiResponse(responseCode = "401", description = "User not registered or password invalid", content = {@Content(schema = @Schema(implementation = AppExceptionResponseDTO.class))}),
    })
    ResponseEntity<UserAuthenticationResponseDTO> loginUser(final UserRequestDTO userRequestDTO) throws UserAuthenticationException;
}
