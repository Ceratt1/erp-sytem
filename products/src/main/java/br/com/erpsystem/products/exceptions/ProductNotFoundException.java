package br.com.erpsystem.products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends IllegalArgumentException {
    
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super();
    }
    
}
