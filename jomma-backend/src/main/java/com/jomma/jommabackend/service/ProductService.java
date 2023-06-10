package com.jomma.jommabackend.service;

import com.jomma.jommabackend.entity.Product;
import com.jomma.jommabackend.entity.Transaction;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> products();

    void saveTransactions(List<Product> products);
}
