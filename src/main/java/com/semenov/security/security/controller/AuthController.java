package com.semenov.security.security.controller;

import com.semenov.security.security.entity.Person;
import com.semenov.security.security.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegistrationService registrationService;

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }


    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/registration";
    }


    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person) {
        registrationService.register(person);
        return "redirect:/auth/login";
    }

}
