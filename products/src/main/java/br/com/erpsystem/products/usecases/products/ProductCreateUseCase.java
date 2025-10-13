package br.com.erpsystem.products.usecases.products;

import org.springframework.stereotype.Service;

import br.com.erpsystem.products.models.Product;
import br.com.erpsystem.products.repositories.IProductRepository;

@Service
public class ProductCreateUseCase {
    
    private final IProductRepository repository;

    public ProductCreateUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    private Product save(Product product) {
        try {
            return repository.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Error saving product: " + e.getMessage());
        }
    }

    public Product execute(Product product) {
        return save(product);
    }

}
