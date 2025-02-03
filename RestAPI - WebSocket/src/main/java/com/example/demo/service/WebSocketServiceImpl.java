package com.example.demo.service;

import com.example.demo.dto.ResponseMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServiceImpl implements WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;


    public WebSocketServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;

    }


    @Override
    public void sendTestNotification(String message) {
        ResponseMessage responseMessage = new ResponseMessage(message);


        messagingTemplate.convertAndSend("/topic/messages", responseMessage);

    }

    @Override
    public void notifyUser(Long id, String message ) {

        ResponseMessage responseMessage = new ResponseMessage(message);

        messagingTemplate.convertAndSendToUser(id.toString(), "/topic/private-messages", responseMessage);

    }





}
