package com.example.ssl_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
    
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Реальный хостинг Java + SSL");
        model.addAttribute("isSecure", request.isSecure());
        model.addAttribute("protocol", request.getScheme());
        model.addAttribute("serverName", request.getServerName());
        model.addAttribute("remoteAddr", request.getRemoteAddr());
        model.addAttribute("timestamp", new java.util.Date());
        
        if (!request.isSecure()) {
            model.addAttribute("warning", "⚠️ ВНИМАНИЕ: Сайт работает по HTTP!");
        } else {
            model.addAttribute("message", "✅ Сайт работает по защищённому HTTPS");
        }
        
        return "index";
    }
    
    @GetMapping("/ssl-test")
    @ResponseBody
    public String sslTest() {
        return "Вы на защищённой странице!";
    }
    
    @GetMapping("/health")
    @ResponseBody
    public String health() {
        return "OK";
    }

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "pong " + new java.util.Date();
}
}