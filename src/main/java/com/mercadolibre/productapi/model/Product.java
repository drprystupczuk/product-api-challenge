package com.mercadolibre.productapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Product {
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

    private String categoryId;
    private String domainId;
    private InstallmentInfo installmentInfo;
    private ShippingInfo shippingInfo;
    
    @JsonProperty("relatedProductIds")
    private List<String> relatedProductIds;
}