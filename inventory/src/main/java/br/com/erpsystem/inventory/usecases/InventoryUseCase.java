package br.com.erpsystem.inventory.usecases;

import org.springframework.stereotype.Component;

@Component
public record InventoryUseCase (
    InventoryGetUseCase get
){
}
