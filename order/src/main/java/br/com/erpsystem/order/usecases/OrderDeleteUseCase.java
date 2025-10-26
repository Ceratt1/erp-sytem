package br.com.erpsystem.order.usecases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.erpsystem.order.exceptions.OrderNotFoundException;
import br.com.erpsystem.order.repositories.IOrderRepository;

@Service
public class OrderDeleteUseCase {
    

    private final IOrderRepository repository;

    public OrderDeleteUseCase(IOrderRepository repository) {
        this.repository = repository;
    }

    private void validateIfExists(UUID uuid) {
        if (repository.findById(uuid).isEmpty()) {
            throw new OrderNotFoundException("Order with id " + uuid + " not found");
        }
    }

    public void execute(UUID uuid) {
        validateIfExists(uuid);
        repository.deleteById(uuid);
    }



}
