package com.semenov.security.security.controller;

import com.semenov.security.security.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class SecurityController {

    private final AdminService adminService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/admin")
    public String adminPage() {
        adminService.doAdminStuff();
        return "admin";
    }
}
