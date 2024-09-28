package com.congwei.service.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/user/home")
    public String getUser() {
        return "user";
    }

    @GetMapping("/admin/home")
    public String getAdmin() {
        return "admin";
    }

}
