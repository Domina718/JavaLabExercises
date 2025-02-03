package com.example.demo.service;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.model.Notification;

import java.util.Set;

public interface NotificationService {

    Set<NotificationDTO> getAllByMember (Long id);

    void saveNotification (Notification notification);



}
