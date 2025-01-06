package com.alura.foro_alura.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    //recibe solo el mensaje
    public ResourceNotFoundException(String message) {
        super(message);
    }

    //recibe el mensaje y la causa
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}