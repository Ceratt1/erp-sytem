package br.com.erpsystem.products.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.erpsystem.products.models.Product;

@Repository
public interface IProductRepository extends MongoRepository<Product, UUID> {
    
}
