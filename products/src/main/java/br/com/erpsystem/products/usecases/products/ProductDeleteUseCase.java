package br.com.erpsystem.products.usecases.products;

import org.springframework.stereotype.Service;

import br.com.erpsystem.products.repositories.IProductRepository;

@Service
public class ProductDeleteUseCase {
    
    private final IProductRepository repository;

    public ProductDeleteUseCase(IProductRepository repository) {
        this.repository = repository;
    }
    public void execute(java.util.UUID uuid) {
        repository.deleteById(uuid);
    }

}
