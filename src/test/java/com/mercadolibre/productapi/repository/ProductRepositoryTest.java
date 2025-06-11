package com.mercadolibre.productapi.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadolibre.productapi.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    @Test
    void findAll_shouldReturnProductsFromJson() {
        ProductRepository repo = new ProductRepository();
        List<Product> products = repo.findAll();

        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertNotNull(products.get(0).getId());
    }

    @Test
    void findById_shouldReturnCorrectProduct() {
        ProductRepository repo = new ProductRepository();
        Product product = repo.findById("MLA1").orElse(null);

        assertNotNull(product);
        assertEquals("MLA1", product.getId());
    }

@Test
void invalidJson_shouldThrowRuntimeException() {
    ProductRepository repo = new ProductRepository() {
        @Override
        public List<Product> findAll() {
            try {
                InputStream inputStream = new ClassPathResource("invalid.json").getInputStream();
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(inputStream, new TypeReference<>() {});
            } catch (IOException e) {
                throw new RuntimeException("Error reading JSON", e);
            }
        }
    };

    RuntimeException exception = assertThrows(RuntimeException.class, repo::findAll);
    assertTrue(exception.getMessage().contains("Error reading JSON"));
}
}