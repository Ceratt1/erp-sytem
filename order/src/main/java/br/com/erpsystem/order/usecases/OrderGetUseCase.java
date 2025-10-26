package br.com.erpsystem.order.usecases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.erpsystem.order.models.Order;
import br.com.erpsystem.order.repositories.IOrderRepository;

@Service
public class OrderGetUseCase {

    
    private final IOrderRepository repository;

    public OrderGetUseCase(IOrderRepository repository) {
        this.repository = repository;
    }

    public Order byId(UUID uuid) {
        return repository.findById(uuid).orElseThrow();
    }




}
