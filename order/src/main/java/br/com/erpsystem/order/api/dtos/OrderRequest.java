package br.com.erpsystem.order.api.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    @NotNull(message = "Product id is required")
    private UUID productId;
    
    @NotNull(message = "Quantity is required")
    @Min(1)
    private Integer quantity;
    
}
