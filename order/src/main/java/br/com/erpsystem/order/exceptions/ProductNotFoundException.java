package br.com.erpsystem.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends  EntityNotFoundException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
