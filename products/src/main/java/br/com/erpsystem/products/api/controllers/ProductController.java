package br.com.erpsystem.products.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.erpsystem.products.api.dtos.product.ProductRequest;
import br.com.erpsystem.products.api.dtos.product.ProductResponse;
import br.com.erpsystem.products.api.mappers.ProductMapper;
import br.com.erpsystem.products.usecases.products.ProductUseCase;


@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductUseCase useCase;

    public ProductController(ProductUseCase useCase) {
        this.useCase = useCase;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody ProductRequest entity) {
        return ProductMapper.toResponse(
            useCase.create().execute(
                ProductMapper.toDomain(entity)
            )
        );
        
    }
    
}
