package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String genre;

    private String publisher;

    @Column(nullable = false)
    private String title;

    private Integer yearPublished;

    private Integer numPages;

    @OneToMany(mappedBy = "book")
    private Set<Reservation> reservation;

    public Book(Long id, String author, String genre, String publisher, String title, Integer yearPublished, Integer numPages) {
        this.id = id;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.title = title;
        this.yearPublished = yearPublished;
        this.numPages = numPages;
    }

    public Book(Long id, String author, String genre, String publisher, String title, Integer yearPublished, Integer numPages, Set<Reservation> reservation) {
        this.id = id;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.title = title;
        this.yearPublished = yearPublished;
        this.numPages = numPages;
        this.reservation = reservation;
    }

    public Book() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    public Set<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(Set<Reservation> reservation) {
        this.reservation = reservation;
    }
}
