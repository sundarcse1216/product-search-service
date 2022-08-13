package com.xyz.product.controller;

import com.xyz.product.model.Products;
import com.xyz.product.response.ApiResponse;
import com.xyz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getProductById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.getAllProductById(id));
    }

    @GetMapping(value = "/search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getProductSearch(@PathVariable("keyword") String keyword) {
        ApiResponse search = productService.getProductsSearch(keyword);
        return ResponseEntity.ok(search);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> addProducts(@RequestBody Products products) {
        return ResponseEntity.ok(productService.saveProduct(products));
    }

}
