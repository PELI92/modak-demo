package modak.peli.demo.modakdemo.notifications.web.rest.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import modak.peli.demo.modakdemo.notifications.enums.NotificationType;

@Value
@Builder
@AllArgsConstructor
public class NotificationRequest {

    @NotNull(message = "notificationType may not be empty")
    NotificationType notificationType;

    @NotNull(message = "chosen name may not be empty")
    @Size(min = 1, max = 10000, message = "chosen_name must be between 1 and 10000 characters long")
    String payload;
}
