package com.gift.website.Repository;



import com.gift.website.Modal.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByIsRead(boolean isRead);
    List<Notification> findByType(String type);
}
