package com.mercadolibre.productapi.dto;

import com.mercadolibre.productapi.model.InstallmentInfo;
import com.mercadolibre.productapi.model.ShippingInfo;
import com.mercadolibre.productapi.model.Seller;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponseDTO {
    private String id;
    private String title;
    private String description;
    private double price;
    private String currency;
    private List<String> pictures;
    private List<String> paymentMethods;
    private Seller seller;
    private int availableStock;
    private int soldQuantity;
    private String warranty;
    private List<String> relatedProductIds;
    private String categoryId;
    private String domainId;
    private InstallmentInfo installmentInfo;
    private ShippingInfo shippingInfo;
}