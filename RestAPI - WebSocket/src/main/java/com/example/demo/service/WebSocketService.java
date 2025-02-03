package com.example.demo.service;

public interface WebSocketService {

    void sendTestNotification(String message);

    void notifyUser(Long id, String message);

}
