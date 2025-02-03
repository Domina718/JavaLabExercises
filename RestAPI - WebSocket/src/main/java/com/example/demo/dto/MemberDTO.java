package com.example.demo.dto;

import com.example.demo.model.Reservation;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Set;

public class MemberDTO {

    private Long id;

    private String name;

    private String email;

    private LocalDate dob;

    private Set<ReservationDTO> reservationDTO;

    private Set<NotificationDTO> notificationDTO;

    public MemberDTO(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public MemberDTO() {
    }

    public MemberDTO(Long id, String name, String email, LocalDate dob, Set<ReservationDTO> reservationDTO, Set<NotificationDTO> notificationDTO) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.reservationDTO = reservationDTO;
        this.notificationDTO = notificationDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Set<ReservationDTO> getReservationDTO() {
        return reservationDTO;
    }

    public void setReservationDTO(Set<ReservationDTO> reservationDTO) {
        this.reservationDTO = reservationDTO;
    }

    public Set<NotificationDTO> getNotificationDTO() {
        return notificationDTO;
    }

    public void setNotificationDTO(Set<NotificationDTO> notificationDTO) {
        this.notificationDTO = notificationDTO;
    }
}
