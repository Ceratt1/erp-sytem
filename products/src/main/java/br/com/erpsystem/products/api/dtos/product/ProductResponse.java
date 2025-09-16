package br.com.erpsystem.products.api.dtos.product;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;

    
}
