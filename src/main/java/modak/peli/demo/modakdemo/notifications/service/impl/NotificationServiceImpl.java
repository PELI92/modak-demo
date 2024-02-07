package modak.peli.demo.modakdemo.notifications.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import modak.peli.demo.modakdemo.notifications.data.access.repository.NotificationRepository;
import modak.peli.demo.modakdemo.notifications.enums.NotificationType;
import modak.peli.demo.modakdemo.notifications.exception.TooSoonException;
import modak.peli.demo.modakdemo.notifications.model.Notification;
import modak.peli.demo.modakdemo.notifications.service.NotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void send(String userId, NotificationType type, String payload) {

        if (isRateLimitExceeded(userId, type)) {
            log.info("Rate limit exceeded for user: " + userId + " and type: " + type);
            throw new TooSoonException();
        }

        Notification notification = Notification.of(
                UUID.randomUUID(),
                userId,
                type,
                LocalDateTime.now()
        );

        notificationRepository.save(notification);
        log.info("** SENDING EMAIL ** " + notification);
    }

    @Override
    public void sanitize() {
        log.info("Sanitizing Notifications");
        for (NotificationType type : NotificationType.values()) {
            deleteOldNotifications(type);
        }
    }

    private boolean isRateLimitExceeded(String userId, NotificationType type) {
        LocalDateTime timestamp = LocalDateTime.now().minusSeconds(type.getRateLimitInSeconds());
        Long count = countByUserIdAndType(userId, type, timestamp);
        return count >= type.getRateLimitCount();
    }

    private Long countByUserIdAndType(String userId, NotificationType type, LocalDateTime timestamp) {
        return notificationRepository.findByUserIdAndType(userId, type).stream()
              .filter(n -> n.getSendAt().isAfter(timestamp))
              .count();
    }

    private void deleteOldNotifications(NotificationType type) {
        LocalDateTime timeLimit = LocalDateTime.now().minusSeconds(type.getRateLimitInSeconds());
        notificationRepository.deleteByTypeAndSendAtBefore(type, timeLimit);
    }
}
