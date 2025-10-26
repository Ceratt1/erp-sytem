package br.com.erpsystem.products.api.mappers;

import java.util.List;

import br.com.erpsystem.products.api.dtos.product.ProductRequest;
import br.com.erpsystem.products.api.dtos.product.ProductResponse;
import br.com.erpsystem.products.models.Product;

public class ProductMapper {
    
    public static Product toDomain(ProductRequest request) {
        Product product = new Product()
            .setName(request.name())
            .setDescription(request.description().orElse(null))
            .setPrice(request.price());
        return product;
    }


    public static List<ProductResponse> toResponse(List<Product> products) {
        return products.stream().map(ProductMapper::toResponse).toList();
    }

    public static ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        return response;
    }

}
