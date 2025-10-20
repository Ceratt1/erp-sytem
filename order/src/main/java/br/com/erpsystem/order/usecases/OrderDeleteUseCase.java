package br.com.erpsystem.order.usecases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.erpsystem.order.exceptions.OrderNotFoundException;
import br.com.erpsystem.order.repositories.OrderRepository;

@Service
public class OrderDeleteUseCase {
    

    private final OrderRepository repository;

    public OrderDeleteUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    private void validateIfExists(UUID uuid) {
        repository.findById(uuid).orElseGet(
            () -> {
                throw new OrderNotFoundException("Order with id " + uuid + " not found");
            }
        );
    }


    public void execute(UUID uuid) {
        validateIfExists(uuid);
        repository.deleteById(uuid);
    }



}
