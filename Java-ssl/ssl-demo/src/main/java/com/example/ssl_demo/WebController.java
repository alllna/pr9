package com.example.ssl_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // ← ИЗМЕНИЛИ ЗДЕСЬ!
public class WebController {
    
    @GetMapping("/")
    public String home() {
        return "Главная страница";
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
    
    @GetMapping("/ssl-test")
    public String sslTest() {
        return "Вы на защищённой странице!";
    }
}