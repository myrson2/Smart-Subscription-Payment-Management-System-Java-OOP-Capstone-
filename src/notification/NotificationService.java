package notification;

public class NotificationService {
    public static void sendNotification(String recipient, String message) {
        // Simulate sending notification (email/SMS)
        System.out.println("[NOTIFICATION] To: " + recipient + " | Message: " + message);
    }
}
