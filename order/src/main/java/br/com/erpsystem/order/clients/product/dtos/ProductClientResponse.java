package br.com.erpsystem.order.clients.product.dtos;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductClientResponse {
    
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;

    
}

