package br.com.erpsystem.inventory.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.erpsystem.inventory.usecases.InventoryUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/inventories")
public class InventoryController {
    
    private final InventoryUseCase useCase;

    public InventoryController(InventoryUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean  getAll(@RequestParam @Valid String skuCode, @RequestParam @Valid Integer quantity) {
        return useCase.get().existsBySkuCodeAndQuantityisGreaterThanEquals(skuCode, quantity);
    }

}
