package com.example.ssl_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Для JSON/текста
public class ApiController {
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
    
    @GetMapping("/ssl-test")
    public String sslTest() {
        return "SSL работает!";
    }
}