package modak.peli.demo.modakdemo.notifications.web.rest;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import modak.peli.demo.modakdemo.notifications.cron.NotificationSanitationJob;
import modak.peli.demo.modakdemo.notifications.enums.NotificationType;
import modak.peli.demo.modakdemo.notifications.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @Operation(
            summary = "Send Notification",
            description = "Send Notification",
            tags = {"Notification"}
    )
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/user/{user_id}/notification", produces = MediaType.APPLICATION_JSON_VALUE)
    public void sendNotification(
            @PathVariable(name = "user_id") String userId,
            @RequestParam(name = "type") NotificationType notificationType,
            @RequestBody String payload
    ) {
        log.info("Sending email to user");
        notificationService.send(userId, notificationType, payload);
    }

    @Operation(
            summary = "Sanitize Notifications",
            description = "Sanitize Notifications",
            tags = {"Notifications"}
    )
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/notification", produces = MediaType.APPLICATION_JSON_VALUE)
    public void sanitizeNotifications(
    ) {
        log.info("Sending email to user");
        notificationService.sanitize();
    }
}
