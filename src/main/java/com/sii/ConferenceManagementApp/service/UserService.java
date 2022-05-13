package com.sii.ConferenceManagementApp.service;

import com.sii.ConferenceManagementApp.user.User;
import com.sii.ConferenceManagementApp.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
    void saveVerificationTokenForUser(String toke, User user);
}
