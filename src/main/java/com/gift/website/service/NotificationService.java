package com.gift.website.service;


import com.gift.website.Modal.Notification;
import com.gift.website.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public Notification addNotification(Notification notification) {
        notification.setTimestamp(LocalDateTime.now());
        notification.setRead(false); // default to unread
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long id, Notification notificationDetails) {
        return notificationRepository.findById(id)
                .map(notification -> {
                    notification.setMessage(notificationDetails.getMessage());
                    notification.setType(notificationDetails.getType());
                    notification.setRead(notificationDetails.isRead());
                    return notificationRepository.save(notification);
                })
                .orElseGet(() -> {
                    notificationDetails.setId(id);
                    return notificationRepository.save(notificationDetails);
                });
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    public List<Notification> getUnreadNotifications() {
        return notificationRepository.findByIsRead(false);
    }

    public List<Notification> getNotificationsByType(String type) {
        return notificationRepository.findByType(type);
    }
}
