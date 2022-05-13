package com.sii.ConferenceManagementApp.event;

import com.sii.ConferenceManagementApp.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleted extends ApplicationEvent {

    private User user;
    private String applicationUrl;

    public RegistrationCompleted(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
