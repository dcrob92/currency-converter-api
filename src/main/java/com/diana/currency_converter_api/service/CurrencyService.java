package com.diana.currency_converter_api.service;

import com.diana.currency_converter_api.dto.request.ConversionRequest;
import com.diana.currency_converter_api.dto.request.CurrencyRequest;
import com.diana.currency_converter_api.dto.response.ConversionResponse;
import com.diana.currency_converter_api.dto.response.CurrencyResponse;

import java.util.List;

public interface CurrencyService {

    CurrencyResponse create(CurrencyRequest request);

    List<CurrencyResponse> findAll();

    CurrencyResponse findById(Long id);

    CurrencyResponse update(Long id, CurrencyRequest request);

    void delete(Long id);

    ConversionResponse convert(ConversionRequest request);
}