package com.sii.ConferenceManagementApp.controller;

import com.sii.ConferenceManagementApp.event.LectureRegistrationCompleted;
import com.sii.ConferenceManagementApp.lecture.Lecture;
import com.sii.ConferenceManagementApp.model.LectureModel;
import com.sii.ConferenceManagementApp.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LectureRegistrationController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private ApplicationEventPublisher publishere;

    @PostMapping("/registerLecture")
    public String registerLecture(@RequestBody LectureModel lectureModel, final HttpServletRequest request) {
        Lecture lecture = lectureService.registerPath(lectureModel);
        publishere.publishEvent(new LectureRegistrationCompleted(
                lecture,
                applicationUrl(request)));
        return "Zarejestrowano nową ścieżkę.";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
