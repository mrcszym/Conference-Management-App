package com.sii.ConferenceManagementApp.lecture;

import com.sii.ConferenceManagementApp.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    public Lecture(String name, String path, String startTime, String endTime) {
        this.name = name;
        this.path = path;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void enrollUser(User user) {
        enrolledUsers.add(user);
    }
}
