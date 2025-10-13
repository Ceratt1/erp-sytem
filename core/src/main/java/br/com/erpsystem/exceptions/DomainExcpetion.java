package br.com.erpsystem.exceptions;


public class DomainExcpetion extends RuntimeException {
    
    public DomainExcpetion() {
        super();
    }

    public DomainExcpetion(String message) {
        super(message);
    }
    
}
