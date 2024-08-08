package com.gift.website.Controller;


import com.gift.website.Modal.Notification;
import com.gift.website.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<com.gift.website.Modal.Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Notification>> getNotificationById(@PathVariable Long id) {
        Optional<Notification> notification = notificationService.getNotificationById(id);
        return ResponseEntity.ok(notification);
    }

    @PostMapping
    public ResponseEntity<Notification> addNotification(@RequestBody Notification notification) {
        Notification newNotification = notificationService.addNotification(notification);
        return ResponseEntity.ok(newNotification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notificationDetails) {
        Notification updatedNotification = notificationService.updateNotification(id, notificationDetails);
        return ResponseEntity.ok(updatedNotification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications() {
        List<Notification> unreadNotifications = notificationService.getUnreadNotifications();
        return ResponseEntity.ok(unreadNotifications);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Notification>> getNotificationsByType(@RequestParam String type) {
        List<Notification> notifications = notificationService.getNotificationsByType(type);
        return ResponseEntity.ok(notifications);
    }
}
