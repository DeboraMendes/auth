package com.deboramendes.auth.controllers.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "User authentication response")
public class UserAuthenticationResponseDTO {
    @Schema(description = "Token", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIwOTM0MTQ5MTk0MCIsImlhdCI6MTY4OTcwNDA1NywiZXhwIjoxNjg5NzA0NjU3fQ.Wk1TatKnkF8r_c2r-gfmDbmnF5VmWK4_CNUqwR-lr2Q")
    private String token;
}
