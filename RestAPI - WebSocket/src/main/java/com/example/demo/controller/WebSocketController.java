package com.example.demo.controller;


import com.example.demo.dto.MessageRequest;
import com.example.demo.service.NotificationService;
import com.example.demo.service.WebSocketService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebSocketController {

    private WebSocketService webSocketService;
    private NotificationService notificationService;

    public WebSocketController(WebSocketService webSocketService, NotificationService notificationService){
        this.webSocketService = webSocketService;
        this.notificationService = notificationService;
    }

    @PostMapping("/send-test-notification")
    public void sendTestNotification(@RequestBody MessageRequest messageRequest){

        webSocketService.sendTestNotification(messageRequest.getContent());
    }

    @GetMapping("/send-test-notification")

    public void sendTestNotification(){
        webSocketService.sendTestNotification("testing");

    }


}
