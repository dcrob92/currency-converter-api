package com.diana.currency_converter_api.dto.response;

import java.time.LocalDateTime;

public record ErrorResponse(

        LocalDateTime timestamp,
        String message

) {
}