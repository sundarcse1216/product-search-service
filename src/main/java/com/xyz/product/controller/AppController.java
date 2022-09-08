package com.xyz.product.controller;

import com.xyz.product.logger.ProductLogger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app")
@RestController
public class AppController {

    private static final ProductLogger LOGGER = ProductLogger.getLogger(AppController.class);

    @GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStatus() {
        LOGGER.info("App Status Check");
        return ResponseEntity.ok("Hi, Product Service Up and Running... :)");
    }

}
