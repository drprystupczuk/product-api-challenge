package com.mercadolibre.productapi.service;

import com.mercadolibre.productapi.exception.ProductNotFoundException;
import com.mercadolibre.productapi.model.Product;
import com.mercadolibre.productapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void getAllProducts_shouldReturnList() {
        Product product = new Product();
        product.setId("MLA1");
        when(productRepository.findAll()).thenReturn(List.of(product));

        var result = productService.getAllProducts();

        assertEquals(1, result.size());
        assertEquals("MLA1", result.get(0).getId());
    }

    @Test
    void getProductById_shouldReturnProduct() {
        Product product = new Product();
        product.setId("MLA1");
        when(productRepository.findById("MLA1")).thenReturn(Optional.of(product));

        var result = productService.getProductById("MLA1");

        assertEquals("MLA1", result.getId());
    }

    @Test
    void getProductById_shouldThrowWhenNotFound() {
        when(productRepository.findById("INVALID")).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> productService.getProductById("INVALID"));
    }
}