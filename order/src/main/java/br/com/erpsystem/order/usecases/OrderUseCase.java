package br.com.erpsystem.order.usecases;

import org.springframework.stereotype.Component;

@Component
public record OrderUseCase(
    OrderCreateUseCase create,
    OrderGetUseCase get,
    OrderDeleteUseCase delete
) {
    
}
