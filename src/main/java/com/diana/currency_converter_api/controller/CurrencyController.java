package com.diana.currency_converter_api.controller;

import com.diana.currency_converter_api.dto.request.CurrencyRequest;
import com.diana.currency_converter_api.dto.response.CurrencyResponse;
import com.diana.currency_converter_api.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CurrencyResponse create(
            @Valid @RequestBody CurrencyRequest request) {

        return service.create(request);
    }

    @GetMapping
    public List<CurrencyResponse> findAll() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public CurrencyResponse findById(
            @PathVariable Long id) {

        return service.findById(id);
    }

    @PutMapping("/{id}")
    public CurrencyResponse update(
            @PathVariable Long id,
            @Valid @RequestBody CurrencyRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }
}