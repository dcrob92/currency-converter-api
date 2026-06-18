package com.diana.currency_converter_api.dto.response;

import java.math.BigDecimal;
import java.util.Map;

public record ConversionResponse(

        BigDecimal amount,
        String sourceCurrency,
        Map<String, BigDecimal> conversions

) {
}