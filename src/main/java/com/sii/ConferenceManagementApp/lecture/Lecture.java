package com.sii.ConferenceManagementApp.lecture;

import com.sii.ConferenceManagementApp.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

    public void enrollUser(User user) {
        enrolledUsers.add(user);
    }
}
