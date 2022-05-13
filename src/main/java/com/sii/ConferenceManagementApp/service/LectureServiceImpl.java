package com.sii.ConferenceManagementApp.service;

import com.sii.ConferenceManagementApp.lecture.Lecture;
import com.sii.ConferenceManagementApp.lecture.LectureRepository;
import com.sii.ConferenceManagementApp.model.LectureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureServiceImpl implements LectureService{

    @Autowired
    private LectureRepository lectureRepository;

    @Override
    public Lecture registerPath(LectureModel lectureModel) {
        Lecture lecture = new Lecture();
        lecture.setName(lectureModel.getName());
        lecture.setPath(lectureModel.getPath());

        lectureRepository.save(lecture);

        return lecture;
    }
}
