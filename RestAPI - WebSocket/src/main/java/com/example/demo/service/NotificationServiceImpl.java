package com.example.demo.service;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.dto.ResponseMessage;
import com.example.demo.model.Notification;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.util.Mapper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;
    private final WebSocketService webSocketService;



    NotificationServiceImpl(NotificationRepository notificationRepository, WebSocketService webSocketService){
        this.notificationRepository = notificationRepository;
        this.webSocketService = webSocketService;

    }

    @Override
    public Set<NotificationDTO> getAllByMember (Long id){
        Set<Notification> notifications = notificationRepository.findAllById(id);

        return Mapper.notificationsToNotificationDTOs(notifications);
    }

    @Override
    public void saveNotification (Notification notification){
        webSocketService.notifyUser(notification.getMember().getId(), notification.getMessage());
        notificationRepository.save(notification);
    }




}
