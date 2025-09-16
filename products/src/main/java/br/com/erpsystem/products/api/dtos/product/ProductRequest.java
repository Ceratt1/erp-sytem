package br.com.erpsystem.products.api.dtos.product;

import java.math.BigDecimal;
import java.util.Optional;

public record ProductRequest( String name, Optional<String> description, BigDecimal price ) {
    public ProductRequest(String name, BigDecimal price) {
        this(name, Optional.empty(), price);
    }
}