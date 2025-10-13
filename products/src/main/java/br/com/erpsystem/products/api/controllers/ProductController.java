package br.com.erpsystem.products.api.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.erpsystem.exceptions.DomainExcpetion;
import br.com.erpsystem.products.api.dtos.product.ProductRequest;
import br.com.erpsystem.products.api.dtos.product.ProductResponse;
import br.com.erpsystem.products.api.mappers.ProductMapper;
import br.com.erpsystem.products.exceptions.ProductNotFoundException;
import br.com.erpsystem.products.usecases.products.ProductUseCase;



@RestController
@RequestMapping("/v1/products")
public class ProductController {
    
    private final ProductUseCase useCase;

    public ProductController(ProductUseCase useCase) {
        this.useCase = useCase;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody ProductRequest entity) throws DomainExcpetion {
        return ProductMapper.toResponse(
            useCase.create().execute(
                ProductMapper.toDomain(entity)
            )
        );        
    }

    @GetMapping("/{uuidProduct}")
    public ProductResponse getByUuid(@PathVariable UUID uuidProduct) throws ProductNotFoundException {
        return ProductMapper.toResponse(
            useCase.getByUuid().execute(uuidProduct)
        );
    }
    
    
}
