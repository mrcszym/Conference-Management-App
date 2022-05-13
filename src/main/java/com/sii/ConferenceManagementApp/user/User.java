package com.sii.ConferenceManagementApp.user;

import com.sii.ConferenceManagementApp.lecture.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @ManyToMany(mappedBy = "enrolledUsers")
    private Set<Lecture> lectures = new HashSet<>();

    @Column(length = 500)
    private String password;
    private String email;
    private String role;
}
