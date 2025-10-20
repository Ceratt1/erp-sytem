package br.com.erpsystem.products.api.dtos.product;

import java.math.BigDecimal;
import java.util.Optional;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(@NotNull(message= "Name is required") String name, Optional<String> description, @NotNull @Min(1) BigDecimal price ) {
    public ProductRequest(String name, BigDecimal price) {
        this(name, Optional.empty(), price);
    }
}