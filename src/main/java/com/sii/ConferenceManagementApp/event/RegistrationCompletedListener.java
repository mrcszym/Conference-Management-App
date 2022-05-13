package com.sii.ConferenceManagementApp.event;

import com.sii.ConferenceManagementApp.user.User;
import com.sii.ConferenceManagementApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompletedListener implements ApplicationListener<RegistrationCompleted> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleted event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

          String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;

        log.info("Kliknij w link by zweryfikowac konto:\n {}", url);
    }
}
