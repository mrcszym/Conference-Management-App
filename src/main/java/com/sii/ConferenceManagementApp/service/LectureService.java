package com.sii.ConferenceManagementApp.service;

import com.sii.ConferenceManagementApp.lecture.Lecture;
import com.sii.ConferenceManagementApp.model.LectureModel;

public interface LectureService {
    Lecture registerPath(LectureModel lectureModel);
}
