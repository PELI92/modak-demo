package modak.peli.demo.modakdemo.notifications.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import modak.peli.demo.modakdemo.notifications.enums.NotificationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@RequiredArgsConstructor(staticName = "of")
@Document
public class Notification {
    @Id
    private final UUID id;
    private final String userId;
    private final NotificationType type;
    private final LocalDateTime sendAt;
}
