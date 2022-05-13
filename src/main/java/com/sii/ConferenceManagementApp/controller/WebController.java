package com.sii.ConferenceManagementApp.controller;

import com.sii.ConferenceManagementApp.lecture.Lecture;
import com.sii.ConferenceManagementApp.lecture.LectureRepository;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    LectureRepository lectureRepository;

    @GetMapping("/")
    public String mainPage(){
        return "Witaj na konferencji!";
    }

    @GetMapping("/home")
    public String home(){
        return "Pomyslnie zalogowano!";
    }

    @GetMapping("/logout")
    protected void configure(final HttpSecurity http) throws Exception {
        http.logout();
    }
}
