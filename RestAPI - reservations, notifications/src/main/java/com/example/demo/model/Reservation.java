package com.example.demo.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Book book;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private LocalDateTime reservationDate;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean fulfilled;


    public Boolean getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(Boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public Reservation() {
    }

    public Reservation(Long id, Member member, Book book, LocalDateTime reservationDate) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.reservationDate = reservationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

}
