package modak.peli.demo.modakdemo.notifications.cron;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import modak.peli.demo.modakdemo.notifications.service.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationSanitationJob {

    private final NotificationService notificationService;

    @Scheduled(cron = "0 */5 * * * *")
    public void execute() {
        log.info("Running notification sanitation job");
        notificationService.sanitize();
    }
}