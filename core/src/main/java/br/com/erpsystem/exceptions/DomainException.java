package br.com.erpsystem.exceptions;


public class DomainException extends RuntimeException {
    
    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
        System.out.println("[DomainException] DomainException: " + message);
    }
    
}
