package com.sii.ConferenceManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String username;
    private String password;
    private String email;
    private String role;
    private String matchingPassword;
}
