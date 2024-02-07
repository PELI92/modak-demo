package modak.peli.demo.modakdemo.notifications.enums;

public enum NotificationType {

    STATUS_UPDATE(2, 60),
    DAILY_NEWS(1, 86400),
    MARKETING(3, 10800);

    private final Integer rateLimitCount;
    private final Integer rateLimitInSeconds;

    NotificationType(Integer rateLimitCount, Integer rateLimitInSeconds) {
        this.rateLimitCount = rateLimitCount;
        this.rateLimitInSeconds = rateLimitInSeconds;
    }

    public Integer getRateLimitCount() {
        return rateLimitCount;
    }

    public Integer getRateLimitInSeconds() {
        return rateLimitInSeconds;
    }
}
