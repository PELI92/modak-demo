package modak.peli.demo.modakdemo.notifications.service;

import modak.peli.demo.modakdemo.notifications.enums.NotificationType;

public interface NotificationService {

    void send(String userId, NotificationType type, String payload);
    void sanitize();
}
