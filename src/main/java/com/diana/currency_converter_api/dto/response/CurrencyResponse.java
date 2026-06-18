package com.diana.currency_converter_api.dto.response;

import java.math.BigDecimal;

public record CurrencyResponse(

        Long id,
        String code,
        String name,
        BigDecimal exchangeRate,
        Boolean active

) {
}