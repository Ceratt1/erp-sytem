package br.com.erpsystem.order.usecases;

import org.springframework.stereotype.Service;

import br.com.erpsystem.exceptions.DomainException;
import br.com.erpsystem.order.models.Order;
import br.com.erpsystem.order.repositories.OrderRepository;

@Service
public class OrderCreateUseCase {
    
    private final OrderRepository repository;

    public OrderCreateUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Order execute(Order order) {

        try {
            return repository.save(order);
        } catch (Exception e) {
            throw new DomainException("Error creating order" + e.getMessage());
        }
    }

}
