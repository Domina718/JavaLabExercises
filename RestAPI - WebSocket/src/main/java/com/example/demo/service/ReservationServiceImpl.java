package com.example.demo.service;

import com.example.demo.controller.MessageController;
import com.example.demo.dto.ReservationDTO;
import com.example.demo.model.Member;
import com.example.demo.model.Notification;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.util.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;

    private final NotificationService notificationService;



    public ReservationServiceImpl(ReservationRepository reservationRepository, NotificationService notificationService){
        this.reservationRepository = reservationRepository;
        this.notificationService = notificationService;

    }

    @Override
    public void addNew (ReservationDTO reservationDTO){
        reservationRepository.save(Mapper.reservationDTOToReservation(reservationDTO));

    }

    @Override
    public void setFulfilled (Long reservationId){
       Reservation res = reservationRepository.findById(reservationId).orElseThrow();

       if(!res.getFulfilled()){
           res.setFulfilled(true);
       }
       else{
           return;
       }

       String message = "Book " + res.getBook().getTitle() + " is now available to borrow.";
       Member member = res.getMember();


       Notification notification = new Notification(message, member, LocalDateTime.now());
       notificationService.saveNotification(notification);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

}
