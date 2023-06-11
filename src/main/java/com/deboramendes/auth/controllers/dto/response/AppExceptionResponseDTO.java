package com.deboramendes.auth.controllers.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Schema(description = "App exception response")
public class AppExceptionResponseDTO {
    @Schema(description = "Date and time", example = "2023-08-01T13:24:58.359+00:00")
    private Timestamp timestamp;

    @Schema(description = "Status code, reason code, domain code and message code", example = "400")
    private Integer code;

    @Schema(description = "Reason", example = "Business error")
    private String reason;

    @Schema(description = "Erros", example = "[username: must not be blank, password: must not be blank]")
    private List<String> erros;
}
