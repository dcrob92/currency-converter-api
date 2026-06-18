package com.diana.currency_converter_api.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record ConversionRequest(

        @NotNull
        @Positive
        BigDecimal amount,

        @NotNull
        String sourceCurrency,

        @NotEmpty
        List<String> targetCurrencies

) {
}