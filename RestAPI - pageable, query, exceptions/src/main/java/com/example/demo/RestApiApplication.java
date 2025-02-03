package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
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
	}
}