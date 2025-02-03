package com.example.demo.dto;

import com.example.demo.model.Book;
import com.example.demo.model.Member;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class NotificationDTO {

    private Long id;

    private String message;

    private MemberDTO memberDTO;
    private LocalDateTime timestamp;

    public NotificationDTO() {
    }

    public NotificationDTO(Long id, String message, MemberDTO memberDTO, LocalDateTime timestamp) {
        this.id = id;
        this.message = message;
        this.memberDTO = memberDTO;
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

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }
}
