package com.diana.currency_converter_api.dto.response;

public record ConversionResult(
    String currency,
    Double value
) {
}