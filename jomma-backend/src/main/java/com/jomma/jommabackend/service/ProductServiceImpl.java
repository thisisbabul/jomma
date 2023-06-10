package com.jomma.jommabackend.service;

import com.jomma.jommabackend.entity.Product;
import com.jomma.jommabackend.entity.Transaction;
import com.jomma.jommabackend.exception.JommaException;
import com.jomma.jommabackend.repository.ProductRepository;
import com.jomma.jommabackend.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public List<Product> products() {
        return productRepository.findAllByActiveStatusIs(Boolean.TRUE);
    }

    @Override
    public void saveTransactions(List<Product> products) {
        try {
            List<Transaction> transactionList = products.stream().map(product ->
                    Transaction.builder()
                            .userId(1L)
                            .product(product)
                            .orderAmount(product.getUnitPrice())
                            .createdOn(LocalDateTime.now())
                            .build()).toList();
            transactionRepository.saveAll(transactionList);
        }
        catch (Exception ex) {
            log.error(ex.getMessage());
            throw new JommaException("Transaction save failed");
        }
    }
}
