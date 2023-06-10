package com.jomma.jommabackend.controller;

import com.jomma.jommabackend.entity.Product;
import com.jomma.jommabackend.entity.Response;
import com.jomma.jommabackend.entity.Transaction;
import com.jomma.jommabackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.jomma.jommabackend.utils.ResponseBuilder.getSuccessResponse;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<Response> products() {
        List<Product> products = productService.products();
        return ResponseEntity.ok(getSuccessResponse(HttpStatus.OK, products, "Product fetched successfully"));
    }

    @PostMapping("")
    public ResponseEntity<Response> saveTransactions(@RequestBody List<Product> products) {
        productService.saveTransactions(products);
        return ResponseEntity.ok(getSuccessResponse(HttpStatus.OK, null, "Transaction saved successfully"));
    }
}
