package com.example.demo.repository;

import com.example.demo.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Set<Notification> findAllById(Long id);
}
