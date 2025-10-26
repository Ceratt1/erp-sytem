package br.com.erpsystem.inventory.usecases;

import org.springframework.stereotype.Service;

import br.com.erpsystem.inventory.repositories.IInventoryRepository;


@Service
public class InventoryGetUseCase {
    
    private final IInventoryRepository repository;

    public InventoryGetUseCase(IInventoryRepository repository) {
        this.repository = repository;
    }

    public boolean existsBySkuCodeAndQuantityisGreaterThanEquals(String skuCode, Integer quantity) {
        return repository.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
    }
}
