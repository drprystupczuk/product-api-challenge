package com.mercadolibre.productapi.model;

import lombok.Data;

@Data
public class Seller {
    private String id;
    private String name;
    private double rating;

    private boolean officialStore; 
    private int totalSales;
}