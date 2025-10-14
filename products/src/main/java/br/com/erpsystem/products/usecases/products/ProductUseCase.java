package br.com.erpsystem.products.usecases.products;

import org.springframework.stereotype.Component;

@Component
public record ProductUseCase(
    ProductCreateUseCase create,
    ProductGetUseCase getByUuid,
    ProductDeleteUseCase delete
    ) {
    
}
