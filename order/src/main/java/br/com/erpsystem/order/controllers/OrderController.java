package br.com.erpsystem.order.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erpsystem.order.usecases.OrderUseCase;


@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    
    private OrderUseCase useCase;

    public OrderController(OrderUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping()
    public String postMethodName() {
        //TODO: process POST request
        
        return "Order created";
    }
    

}
