package com.jomma.jommabackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private long productId;

    private String productName;

    private String productCode;

    private double unitPrice;

    private double gainLoss;

    private double yearToDate;

    private boolean activeStatus;
}
