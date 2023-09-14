package com.devnic.order_service.configs;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Nicholas Nzovia
 * @On 12/09/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Configuration
public class WebClientConfiguration { //this is for synchronous communication between services
    @Bean
    @LoadBalanced //client side load balancing
    public WebClient.Builder webClient(){
        return WebClient.builder();
    }
}
