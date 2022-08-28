package com.xyz.product;

import com.xyz.product.logger.ProductLogger;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductSearchServiceApplication {
    private static final ProductLogger LOGGER = ProductLogger.getLogger(ProductSearchServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductSearchServiceApplication.class, args);
        LOGGER.info("Product Service started successfully...");
    }

}
