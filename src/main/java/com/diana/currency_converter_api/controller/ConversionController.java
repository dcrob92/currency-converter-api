package com.diana.currency_converter_api.controller;

import com.diana.currency_converter_api.dto.request.ConversionRequest;
import com.diana.currency_converter_api.dto.response.ConversionResponse;
import com.diana.currency_converter_api.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversions")
@RequiredArgsConstructor
public class ConversionController {

    private final CurrencyService service;

    @PostMapping
    public ConversionResponse convert(
            @Valid @RequestBody ConversionRequest request) {

        return service.convert(request);
    }
}