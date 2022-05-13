package com.sii.ConferenceManagementApp.lecture;

import com.sii.ConferenceManagementApp.user.User;
import com.sii.ConferenceManagementApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    Lecture createLecture(@RequestBody Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @PutMapping("/{lectureId}/users/{userId}")
    Lecture enrollUserToLecture(
            @PathVariable Long lectureId,
            @PathVariable Long userId
    ) {
        Lecture lecture = lectureRepository.findById(lectureId).get();
        User user = userRepository.findById(userId).get();
        lecture.enrolledUsers.add(user);

        return lectureRepository.save(lecture);
    }
}
