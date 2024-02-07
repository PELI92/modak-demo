[Backend] Rate-Limited Notification Service

Default rules:
- Status: not more than 2 per minute for each recipient
- News: not more than 1 per day for each recipient
- Marketing: not more than 3 per hour for each recipient

Considerations:
- I am assuming there is a very high flow in a NotificationService, so I am using a distributed system to handle the rate limiting in order to allow a horizontal scaling.
- I just add a simple test to focus on other priorities, but I am aware that I should add more tests to cover all the scenarios (at least 85% coverage, including integration tests).
- For simplicity, I am using a ENUM to model NotificationType and their rules, but in a real scenario, I would use a database to store the rules and allow the admin to change them.

## How to run the project

```
docker-compose up
```

## How to test the project
swagger-ui: http://localhost:8080/swagger-ui/index.html
