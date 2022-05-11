package com.sii.ConferenceManagementApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "Strona glowna";
    }

    @GetMapping("/home")
    public String home(){
        return "Home Page";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Admin Page";
    }
}
