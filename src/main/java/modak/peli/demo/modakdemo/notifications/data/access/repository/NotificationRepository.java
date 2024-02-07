package modak.peli.demo.modakdemo.notifications.data.access.repository;

import modak.peli.demo.modakdemo.notifications.enums.NotificationType;
import modak.peli.demo.modakdemo.notifications.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByUserIdAndType(String userId, NotificationType notificationType);
    void deleteByTypeAndSendAtBefore(NotificationType type, LocalDateTime sendAt);
}
