package com.mercadolibre.productapi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.productapi.model.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    public List<Product> findAll() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource("products.json").getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<List<Product>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error reading products.json", e);
        }
    }

    public Optional<Product> findById(String id) {
        return findAll()
                .stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst();
    }
}