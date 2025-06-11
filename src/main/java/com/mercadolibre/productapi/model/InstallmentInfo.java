package com.mercadolibre.productapi.model;

import lombok.Data;

@Data
public class InstallmentInfo {
    private int quantity;
    private double amount;
    private boolean noInterest;
}