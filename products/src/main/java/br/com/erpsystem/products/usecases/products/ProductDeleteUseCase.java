package br.com.erpsystem.products.usecases.products;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.erpsystem.products.exceptions.ProductNotFoundException;
import br.com.erpsystem.products.repositories.IProductRepository;

@Service
public class ProductDeleteUseCase {
    
    private final IProductRepository repository;

    public ProductDeleteUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    private void validateIfExists(UUID uuid) {
        if (repository.findById(uuid).isEmpty()) {
            throw new ProductNotFoundException("Product with id " + uuid + " not found");
        }
    }

    public void execute(UUID uuid) {
        validateIfExists(uuid);
        repository.deleteById(uuid);
    }

}
