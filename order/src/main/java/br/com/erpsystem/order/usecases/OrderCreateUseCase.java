package br.com.erpsystem.order.usecases;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.erpsystem.exceptions.DomainException;
import br.com.erpsystem.order.clients.inventory.service.IInventoryClientService;
import br.com.erpsystem.order.clients.product.dtos.ProductClientResponse;
import br.com.erpsystem.order.clients.product.service.IProductClientService;
import br.com.erpsystem.order.models.Order;
import br.com.erpsystem.order.repositories.IOrderRepository;

@Service
public class OrderCreateUseCase {
    
    private final IOrderRepository repository;
    private final IInventoryClientService inventoryClientService;
    private final IProductClientService productClientService;


    public OrderCreateUseCase(IOrderRepository repository, IInventoryClientService inventoryClientService, IProductClientService productClientService) {
        this.repository = repository;
        this.inventoryClientService = inventoryClientService;
        this.productClientService = productClientService;
    }

    private void validateInventory(String skuCode, Integer quantity) {
        if (!inventoryClientService.isInStock(skuCode, quantity)) {
            throw new DomainException("Product " + skuCode + " not in stock");
        }
    }

    private Order save(Order order) {
        try {
            return repository.save(order);
        } catch (Exception e) {
            throw new DomainException("Error saving order: " + e.getMessage());
        }
    }

    public Order execute(Order order) {
        validateInventory(order.getSkuCode(), order.getQuantity());
        ProductClientResponse productResponse = productClientService.findById(order.getProductId());
        BigDecimal totalPrice = productResponse.getPrice().multiply(new BigDecimal(order.getQuantity()));
        order.setSkuCode(productResponse.getName());
        order.setPrice(totalPrice);
        return save(order);
    }

}
