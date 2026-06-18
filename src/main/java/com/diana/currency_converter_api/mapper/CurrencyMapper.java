package com.diana.currency_converter_api.mapper;

import com.diana.currency_converter_api.dto.request.CurrencyRequest;
import com.diana.currency_converter_api.dto.response.CurrencyResponse;
import com.diana.currency_converter_api.entity.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {

    public Currency toEntity(CurrencyRequest request) {

        return Currency.builder()
                .code(request.code().toUpperCase())
                .name(request.name())
                .exchangeRate(request.exchangeRate())
                .active(true)
                .build();
    }

    public CurrencyResponse toResponse(Currency currency) {

        return new CurrencyResponse(
                currency.getId(),
                currency.getCode(),
                currency.getName(),
                currency.getExchangeRate(),
                currency.getActive()
        );
    }
}