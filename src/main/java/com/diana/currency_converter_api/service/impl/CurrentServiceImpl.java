package com.diana.currency_converter_api.service.impl; 

import lombok.RequiredArgsConstructor;
import com.diana.currency_converter_api.repository.CurrencyRepository;
import com.diana.currency_converter_api.exception.CurrencyNotFoundException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.diana.currency_converter_api.dto.request.ConversionRequest;
import com.diana.currency_converter_api.dto.request.CurrencyRequest;
import com.diana.currency_converter_api.dto.response.ConversionResponse;
import com.diana.currency_converter_api.dto.response.CurrencyResponse;
import com.diana.currency_converter_api.entity.Currency;
import com.diana.currency_converter_api.mapper.CurrencyMapper;
import com.diana.currency_converter_api.service.CurrencyService;

@Service
@RequiredArgsConstructor
public class CurrentServiceImpl implements CurrencyService {

    private final CurrencyRepository repository;
    private final CurrencyMapper mapper;

    @Override
    public CurrencyResponse create(CurrencyRequest request) {
        Currency currency = mapper.toEntity(request);
        Currency saved = repository.save(currency);
        return mapper.toResponse(saved);
    }

    @Override
    public List<CurrencyResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CurrencyResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new CurrencyNotFoundException("Divisa no encontrada por id: " + id));
    }

    @Override
    public CurrencyResponse update(Long id, CurrencyRequest request) {
        Currency existing = repository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Divisa no encontrada por id: " + id));

        existing.setCode(request.code().toUpperCase());
        existing.setName(request.name());
        existing.setExchangeRate(request.exchangeRate());

        Currency updated = repository.save(existing);
        return mapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new CurrencyNotFoundException("Divisa no encontrada por id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public ConversionResponse convert(ConversionRequest request) {
        Currency sourceCurrency = repository.findByCode(request.sourceCurrency().toUpperCase())
                .orElseThrow(() -> new CurrencyNotFoundException("Divisa de origen no encontrada: " + request.sourceCurrency()));

        Map<String, BigDecimal> conversions = request.targetCurrencies().stream()
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.toMap(
                        targetCode -> targetCode,
                        targetCode -> {
                            Currency targetCurrency = repository.findByCode(targetCode)
                                    .orElseThrow(() -> new CurrencyNotFoundException("Divisa de destino no encontrada: " + targetCode));
                            return request.amount()
                                    .multiply(targetCurrency.getExchangeRate())
                                    .divide(sourceCurrency.getExchangeRate(), RoundingMode.HALF_UP);
                        }
                ));

        return new ConversionResponse(request.amount(), sourceCurrency.getCode(), conversions);
    }
}