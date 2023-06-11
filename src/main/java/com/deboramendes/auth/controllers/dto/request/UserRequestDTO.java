package com.deboramendes.auth.controllers.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "User request")
public class UserRequestDTO {
    @NotBlank
    @Length(min = 3, max = 11)
    @Schema(description = "Username", example = "00321232054")
    private final String username;

    @NotBlank
    @Length(min = 3, max = 15)
    @Schema(description = "Password", example = "y&RF1r784^B%")
    private final String password;
}
