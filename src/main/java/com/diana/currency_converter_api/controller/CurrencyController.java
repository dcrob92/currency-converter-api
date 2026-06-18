package com.diana.currency_converter_api.controller;

import com.diana.currency_converter_api.dto.request.CurrencyRequest;
import com.diana.currency_converter_api.dto.response.CurrencyResponse;
import com.diana.currency_converter_api.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174", "http://localhost:5175"})

@RestController
@RequestMapping("/api/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService service;

    @Operation(summary = "Crear una nueva divisa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CurrencyResponse create(
            @Valid @RequestBody CurrencyRequest request) {

        return service.create(request);
    }

    @Operation(summary = "Listar todas las divisas")
    @GetMapping
    public List<CurrencyResponse> findAll() {

        return service.findAll();
    }

    @Operation(summary = "Buscar divisa por ID")
    @GetMapping("/{id}")
    public CurrencyResponse findById(
            @PathVariable Long id) {

        return service.findById(id);
    }

    @Tag(name = "Divisas", description = "Operaciones relacionadas con divisas")
    @Operation(summary = "Actualizar divisa existente")
    @PutMapping("/{id}")
    public CurrencyResponse update(
            @PathVariable Long id,
            @Valid @RequestBody CurrencyRequest request) {

        return service.update(id, request);
    }

    @Tag(name = "Divisas", description = "Operaciones relacionadas con divisas")
    @Operation(summary = "Eliminar divisa existente")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }

    
}