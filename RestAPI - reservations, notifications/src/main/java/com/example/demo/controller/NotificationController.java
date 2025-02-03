package com.example.demo.controller;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;


    public NotificationController (NotificationService notificationService){
        this.notificationService = notificationService;
    }


    @GetMapping("/member/{memberId}")
    public ResponseEntity<Set<NotificationDTO>> getNotifications (@PathVariable Long memberId){
        return ResponseEntity.ok(notificationService.getAllByMember(memberId));

    }

}
