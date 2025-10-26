package br.com.erpsystem.order.usecases;

import org.springframework.stereotype.Service;

import br.com.erpsystem.exceptions.DomainException;
import br.com.erpsystem.order.models.Order;
import br.com.erpsystem.order.repositories.IOrderRepository;

@Service
public class OrderCreateUseCase {
    
    private final IOrderRepository repository;

    public OrderCreateUseCase(IOrderRepository repository) {
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
