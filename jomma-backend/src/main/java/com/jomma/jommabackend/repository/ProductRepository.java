package com.jomma.jommabackend.repository;

import com.jomma.jommabackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByActiveStatusIs(boolean activeStatus);
}
