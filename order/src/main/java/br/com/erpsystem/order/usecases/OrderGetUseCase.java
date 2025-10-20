package br.com.erpsystem.order.usecases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.erpsystem.order.models.Order;
import br.com.erpsystem.order.repositories.OrderRepository;

@Service
public class OrderGetUseCase {

    
    private final OrderRepository repository;

    public OrderGetUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Order byId(UUID uuid) {
        return repository.findById(uuid).orElseThrow();
    }




}
