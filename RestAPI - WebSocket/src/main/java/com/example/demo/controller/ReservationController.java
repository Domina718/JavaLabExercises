package com.example.demo.controller;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;



    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping("/")
    public ResponseEntity<String> addReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.addNew(reservationDTO);
        return ResponseEntity.ok("Reservation successfully added.");
    }

    @GetMapping("/")
    public List<Reservation> getReservations(){
         return reservationService.getAll();

    }

    @PutMapping("/{reservationId}/fulfill")
    public ResponseEntity<?> fulfillReservation(@PathVariable Long reservationId) {
        reservationService.setFulfilled(reservationId);
        return ResponseEntity.ok("Reservation is fulfilled.");
    }


}
