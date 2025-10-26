package br.com.erpsystem.order.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.erpsystem.order.api.dtos.OrderRequest;
import br.com.erpsystem.order.api.dtos.OrderResponse;
import br.com.erpsystem.order.api.mapper.OrderMapper;
import br.com.erpsystem.order.usecases.OrderUseCase;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    
    private final OrderUseCase useCase;

    public OrderController(OrderUseCase useCase) {
        this.useCase = useCase;
    }

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@RequestBody @Valid OrderRequest request) {
        return OrderMapper.toResponse(
            useCase.create().execute(
                OrderMapper.toDomain(request)
            )
        );
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAll() {
        return OrderMapper.toResponseList(
            useCase.get().execute()
        );
    }
}
