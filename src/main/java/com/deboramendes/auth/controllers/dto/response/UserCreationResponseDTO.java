package com.deboramendes.auth.controllers.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(description = "User creation response")
public class UserCreationResponseDTO {
    @Schema(description = "User id", example = "3d32bddb-8347-4683-a7f6-fe51f3d4cd38")
    private UUID id;
}
