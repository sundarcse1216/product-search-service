package com.xyz.product.config;

import com.xyz.product.response.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class AppConfiguration {

    @Bean
    public ApiResponse apiResponse() {
        return new ApiResponse();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate() {
            {
                setInterceptors(Collections.singletonList(new ClientCorrelationIdInterceptor()));
            }
        };
    }
}
