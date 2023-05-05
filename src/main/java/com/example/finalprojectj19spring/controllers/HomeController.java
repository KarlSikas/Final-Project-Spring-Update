package com.example.finalprojectj19spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String showHomePage() {
        return "home";
    }
}