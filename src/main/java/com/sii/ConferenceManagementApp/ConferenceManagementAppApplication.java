package com.sii.ConferenceManagementApp;

import com.sii.ConferenceManagementApp.lecture.Lecture;
import com.sii.ConferenceManagementApp.lecture.LectureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ConferenceManagementAppApplication {

	//Wykona się również CommandLineRunner, którego zadaniem jest stworzenie 9 ścieżek konferencji
	public static void main(String[] args) {
		SpringApplication.run(ConferenceManagementAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LectureRepository lectureRepository) {

		String startTime1 = "2021-06-01 10:00";
		String startTime2 = "2021-06-01 12:00";
		String startTime3 = "2021-06-01 14:00";

		String endTime1 = "2021-06-01 11:45";
		String endTime2 = "2021-06-01 13:45";
		String endTime3 = "2021-06-01 15:45";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		LocalDateTime formatStartTime1 = LocalDateTime.parse(startTime1, formatter);
		LocalDateTime formatStartTime2 = LocalDateTime.parse(startTime2, formatter);
		LocalDateTime formatStartTime3 = LocalDateTime.parse(startTime3, formatter);

		LocalDateTime formatEndTime1 = LocalDateTime.parse(endTime1, formatter);
		LocalDateTime formatEndTime2 = LocalDateTime.parse(endTime2, formatter);
		LocalDateTime formatEndTime3 = LocalDateTime.parse(endTime3, formatter);

		return args -> {
			lectureRepository.deleteAll();
			List<Lecture> lectureList = new ArrayList<>(List.of(
					new Lecture("Prelekcja 1", "sciezka 1", Collections.emptySet(),
							formatStartTime1.format(formatter), formatEndTime1.format(formatter)),

					new Lecture("Prelekcja 1", "sciezka 2", Collections.emptySet(),
							formatStartTime1.format(formatter), formatEndTime1.format(formatter)),

					new Lecture("Prelekcja 1", "sciezka 3", Collections.emptySet(),
							formatStartTime1.format(formatter), formatEndTime1.format(formatter)),

					new Lecture("Prelekcja 2", "sciezka 1", Collections.emptySet(),
							formatStartTime2.format(formatter), formatEndTime2.format(formatter)),

					new Lecture("Prelekcja 2", "sciezka 2", Collections.emptySet(),
							formatStartTime2.format(formatter), formatEndTime2.format(formatter)),

					new Lecture("Prelekcja 2", "sciezka 3", Collections.emptySet(),
							formatStartTime2.format(formatter), formatEndTime2.format(formatter)),

					new Lecture("Prelekcja 3", "sciezka 1", Collections.emptySet(),
							formatStartTime3.format(formatter), formatEndTime3.format(formatter)),

					new Lecture("Prelekcja 3", "sciezka 2", Collections.emptySet(),
							formatStartTime3.format(formatter), formatEndTime3.format(formatter)),

					new Lecture("Prelekcja 3", "sciezka 3", Collections.emptySet(),
							formatStartTime3.format(formatter), formatEndTime3.format(formatter))

			));
			lectureRepository.saveAll(lectureList);
		};
	}
}
