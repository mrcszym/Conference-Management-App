package com.sii.ConferenceManagementApp.event;

import com.sii.ConferenceManagementApp.lecture.Lecture;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class LectureRegistrationCompleted extends ApplicationEvent {

    private Lecture lecture;
    private String appUrl;

    public LectureRegistrationCompleted(Lecture lecture, String appUrl) {
        super(lecture);
        this.lecture = lecture;
        this.appUrl = appUrl;
    }
}


