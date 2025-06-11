package com.mercadolibre.productapi.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super("Producto con ID '" + id + "' no encontrado.");
    }
}