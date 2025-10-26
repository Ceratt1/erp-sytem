package br.com.erpsystem.order.clients.product.service;

import java.util.UUID;

import br.com.erpsystem.order.clients.product.dtos.ProductClientResponse;

public interface IProductClientService {
    
    ProductClientResponse findById(UUID productId);
    
}
