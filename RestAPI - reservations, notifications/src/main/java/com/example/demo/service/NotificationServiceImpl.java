package com.example.demo.service;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.model.Notification;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;

    NotificationServiceImpl(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Set<NotificationDTO> getAllByMember (Long id){
        Set<Notification> notifications = notificationRepository.findAllById(id);

        return Mapper.notificationsToNotificationDTOs(notifications);
    }

    @Override
    public void saveNotification (Notification notification){
        notificationRepository.save(notification);
    }



}
