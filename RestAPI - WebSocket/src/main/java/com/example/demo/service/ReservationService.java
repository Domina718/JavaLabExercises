package com.example.demo.service;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.dto.ResponseMessage;
import com.example.demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationService {

    void addNew(ReservationDTO reservationDTO);

    void setFulfilled(Long id);


    List<Reservation> getAll();
}
