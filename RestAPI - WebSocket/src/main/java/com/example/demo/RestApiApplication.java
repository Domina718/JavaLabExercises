package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.model.Member;
import com.example.demo.model.Reservation;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.ReservationRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class RestApiApplication implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	ReservationRepository reservationRepository;




	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		TypeReference<List<Book>> typeReference = new TypeReference<>() {};
		List<Book> books = objectMapper.readValue(new File("src/main/resources/books.json"), typeReference);
		for (Book book: books) {
			bookRepository.save(book);
		}

		TypeReference<List<Member>> typeReferenceMember = new TypeReference<>() {};
		List<Member> members = objectMapper.readValue(new File("src/main/resources/members.json"), typeReferenceMember);
		for (Member member: members) {
			memberRepository.save(member);
		}

		TypeReference<List<Reservation>> typeReferenceReservation = new TypeReference<>() {};
		List<Reservation> reservations = objectMapper.readValue(new File("src/main/resources/reservations.json"), typeReferenceReservation);
		for (Reservation reservation : reservations) {
			reservationRepository.save(reservation);
		}
	}
}