package com.diana.currency_converter_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CurrencyRequest(

        @NotBlank
        String code,

        @NotBlank
        String name,

        @NotNull
        @Positive
        BigDecimal exchangeRate

) {
}