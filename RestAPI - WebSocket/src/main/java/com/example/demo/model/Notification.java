package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Member member;

//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Book book;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Member member;

    private LocalDateTime timestamp;


    public Notification() {
    }

    public Notification(Long id, String message, Member member, LocalDateTime timestamp) {
        this.id = id;
        this.message = message;
        this.member = member;
        this.timestamp = timestamp;
    }


    public Notification(String message, Member member, LocalDateTime timestamp) {
        this.message = message;
        this.member = member;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
