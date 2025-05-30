package com.phone.controller;

import com.phone.dto.CountryDtoRequest;
import com.phone.dto.CountryDtoResponse;
import com.phone.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Страны", description = "API для управления странами")
@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @Operation(summary = "Получить список всех стран")
    @GetMapping
    public List<CountryDtoResponse> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Получить страну по коду")
    @GetMapping("/{code}")
    public CountryDtoResponse getByCode(
            @Parameter(description = "Код страны") @PathVariable String code) {
        return service.getByCode(code);
    }

    @Operation(summary = "Создать новую страну")
    @PostMapping("/save")
    public CountryDtoResponse save(
            @Parameter(description = "Данные новой страны")
            @RequestBody @Valid CountryDtoRequest request) {
        return service.save(request);
    }

    @Operation(summary = "Обновить страну")
    @PutMapping("/{code}")
    public CountryDtoResponse update(
            @Parameter(description = "Код страны") @PathVariable String code,
            @Parameter(description = "Обновленные данные страны")
            @RequestBody @Valid CountryDtoRequest request) {
        return service.update(code, request);
    }

    @Operation(summary = "Удалить страну")
    @DeleteMapping("/{code}")
    public void delete(
            @Parameter(description = "Код страны") @PathVariable String code) {
        service.delete(code);
    }

    @Operation(summary = "Поиск страны по значению (код, имя или телефонный код)")
    @GetMapping("/lookup")
    public CountryDtoResponse lookup(
            @Parameter(description = "Значение для поиска") @RequestParam String value) {
        return service.lookup(value);
    }
}
