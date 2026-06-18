package com.diana.currency_converter_api.controller;

import com.diana.currency_converter_api.dto.request.ConversionRequest;
import com.diana.currency_converter_api.dto.response.ConversionResponse;
import com.diana.currency_converter_api.service.ConversionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174", "http://localhost:5175"})
@RestController
@RequestMapping("/api/conversions")
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService service;

    @Tag(name = "Divisas", description = "Operaciones entre divisas")
    @Operation(summary = "Convertir divisa")
    @PostMapping
    public ConversionResponse convert(@Valid @RequestBody ConversionRequest request) {
        return service.convert(request);
    }
}