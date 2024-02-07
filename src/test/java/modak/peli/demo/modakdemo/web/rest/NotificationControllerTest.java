package modak.peli.demo.modakdemo.web.rest;

import modak.peli.demo.modakdemo.notifications.enums.NotificationType;
import modak.peli.demo.modakdemo.notifications.service.NotificationService;
import modak.peli.demo.modakdemo.notifications.web.rest.NotificationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class NotificationControllerTest {

    @Mock
    private NotificationService notificationService;

    private NotificationController notificationController;

    @BeforeEach
    void setUp() {
        notificationController = new NotificationController(notificationService);
    }

    @Test
    void when_post_notification_then_return_200() {
        // given
        String userId = "user_id";
        NotificationType notificationType = NotificationType.STATUS_UPDATE;
        String payload = "payload";

        doNothing().when(notificationService).send(eq(userId), eq(notificationType), eq(payload));

        // when
        notificationController.sendNotification(userId, notificationType, payload);

        // then
        verify(notificationService).send(eq(userId), eq(notificationType), eq(payload));
    }

    @Test
    void when_delete_notification_then_return_200() {
        // given
        doNothing().when(notificationService).sanitize();

        // when
        notificationController.sanitizeNotifications();

        // then
        verify(notificationService).sanitize();
    }
}
