package br.com.erpsystem.products.usecases.products;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.erpsystem.products.exceptions.ProductNotFoundException;
import br.com.erpsystem.products.models.Product;
import br.com.erpsystem.products.repositories.IProductRepository;

@Service
public class ProductGetUseCase {
    
    private final IProductRepository repository;

    public ProductGetUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(UUID uuid) throws ProductNotFoundException {
        return repository.findById(uuid).orElseThrow(() -> new ProductNotFoundException("Product not found with UUID: " + uuid));
    }

}
