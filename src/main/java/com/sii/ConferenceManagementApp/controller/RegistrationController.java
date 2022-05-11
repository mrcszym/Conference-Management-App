package com.sii.ConferenceManagementApp.controller;

import com.sii.ConferenceManagementApp.entity.User;
import com.sii.ConferenceManagementApp.event.RegistrationCompleted;
import com.sii.ConferenceManagementApp.model.UserModel;
import com.sii.ConferenceManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/home")
    public String home(){
        return "Home Page";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleted(
                user,
                applicationUrl(request)));
        return "Rejestracja zakonczona sukcesem!";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
