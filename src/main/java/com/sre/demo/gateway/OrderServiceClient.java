package com.sre.demo.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class OrderServiceClient {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${order.service.url:http://order-service:8080}")
    private String orderServiceUrl;
    
    public Map<String, Object> createOrder(Map<String, Object> order) {
        String url = orderServiceUrl + "/orders";
        return restTemplate.postForObject(url, order, Map.class);
    }
}