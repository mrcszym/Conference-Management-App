package com.sii.ConferenceManagementApp.lecture;

import com.sii.ConferenceManagementApp.user.User;
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
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany
    @JoinTable(
            name="user_enrolled",
            joinColumns = @JoinColumn(name = "lecture_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<User> enrolledUsers = new HashSet<>();

    private String name;
    private String path;
    private String startTime;
    private String endTime;

    public Lecture(String name, String path, Set<User>enrolledUsers, String startTime, String endTime) {
        this.name = name;
        this.path = path;
        this.enrolledUsers = enrolledUsers;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Set<User> getEnrolledUsers() {
        return enrolledUsers;
    }
}
