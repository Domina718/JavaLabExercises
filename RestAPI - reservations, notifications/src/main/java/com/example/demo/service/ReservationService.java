package com.example.demo.service;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationService {

    void addNew(ReservationDTO reservationDTO);

    void setFulfilled(Long id);

}
