package com.sii.ConferenceManagementApp.lecture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture,Long> {}
