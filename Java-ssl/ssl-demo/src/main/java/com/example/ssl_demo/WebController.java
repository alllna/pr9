package com.example.ssl_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody; 
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WebController {
    
    @GetMapping("/")
    public String home(HttpServletRequest request, org.springframework.ui.Model model) {
        model.addAttribute("title", "Реальный хостинг Java + SSL");
        model.addAttribute("isSecure", request.isSecure());
        return "index";  // Это Thymeleaf шаблон
    }
    
    @GetMapping("/health")
    @ResponseBody  // ← ВАЖНО! Говорит Spring что это не шаблон
    public String health() {
        return "OK";  // Просто текст
    }
    
    @GetMapping("/ssl-test")
    @ResponseBody  // ← ВАЖНО!
    public String sslTest() {
        return "Вы на защищённой странице!";
    }
}