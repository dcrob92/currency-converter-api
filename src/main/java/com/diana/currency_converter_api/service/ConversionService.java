package com.diana.currency_converter_api.service;

import com.diana.currency_converter_api.dto.request.ConversionRequest;
import com.diana.currency_converter_api.dto.response.ConversionResponse;
import com.diana.currency_converter_api.exception.CurrencyNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConversionService {

    // Puedes luego reemplazar esto por BD
    private final Map<String, BigDecimal> rates = new HashMap<>();

    public ConversionService() {
        rates.put("USD", BigDecimal.ONE);
        rates.put("COP", BigDecimal.valueOf(4000));
        rates.put("EUR", BigDecimal.valueOf(0.92));
        rates.put("BRL", BigDecimal.valueOf(5));
        rates.put("MXN", BigDecimal.valueOf(17));
        rates.put("GBP", BigDecimal.valueOf(0.79));
        rates.put("ARS", BigDecimal.valueOf(850));
        rates.put("CLP", BigDecimal.valueOf(900));
        rates.put("PEN", BigDecimal.valueOf(3.7));
        rates.put("CAD", BigDecimal.valueOf(1.35));
    }

    public ConversionResponse convert(ConversionRequest request) {
        String sourceCurrency = request.sourceCurrency().toUpperCase();
        BigDecimal baseRate = getRate(sourceCurrency);

        BigDecimal usdAmount = request.amount()
                .divide(baseRate, 6, RoundingMode.HALF_UP);

        Map<String, BigDecimal> result = new HashMap<>();

        for (String currency : request.targetCurrencies()) {
            String targetCurrency = currency.toUpperCase();
            result.put(targetCurrency, usdAmount.multiply(getRate(targetCurrency)));
        }

        return new ConversionResponse(
                request.amount(),
                sourceCurrency,
                result
        );
    }

    private BigDecimal getRate(String currencyCode) {
        BigDecimal rate = rates.get(currencyCode);

        if (rate == null) {
            throw new CurrencyNotFoundException("Divisa no encontrada: " + currencyCode);
        }

        return rate;
    }
}