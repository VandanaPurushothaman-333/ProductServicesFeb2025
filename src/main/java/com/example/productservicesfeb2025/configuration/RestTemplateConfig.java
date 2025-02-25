package com.example.productservicesfeb2025.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    // Name of the class/method doesn't a matter, but annotations should be proper
    // Create a bean of restTemplate.

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
