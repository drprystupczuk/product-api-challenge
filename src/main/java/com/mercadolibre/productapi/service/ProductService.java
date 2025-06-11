package com.mercadolibre.productapi.service;

import com.mercadolibre.productapi.dto.ProductResponseDTO;
import com.mercadolibre.productapi.exception.ProductNotFoundException;
import com.mercadolibre.productapi.model.Product;
import com.mercadolibre.productapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ProductResponseDTO getProductById(String id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));

        return toDTO(product);
    }

    public ProductResponseDTO toDTO(Product product) {
        return ProductResponseDTO.builder()
            .id(product.getId())
            .title(product.getTitle())
            .description(product.getDescription())
            .price(product.getPrice())
            .currency(product.getCurrency())
            .pictures(product.getPictures())
            .paymentMethods(product.getPaymentMethods())
            .seller(product.getSeller())
            .availableStock(product.getAvailableStock())
            .soldQuantity(product.getSoldQuantity())
            .warranty(product.getWarranty())
            .relatedProductIds(product.getRelatedProductIds())
            .categoryId(product.getCategoryId())
            .domainId(product.getDomainId())
            .installmentInfo(product.getInstallmentInfo())
            .shippingInfo(product.getShippingInfo())
            .build();
    }   
}