package com.hanniel.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){

        return "access-denied";
    }
}
