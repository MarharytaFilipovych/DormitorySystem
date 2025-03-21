package notifications;

import enums.NotificationType;

public class SMSNotification extends Notification{
    public SMSNotification(long id, String message, NotificationType type) {
        super(id, message, type);
    }

    @Override
    public boolean send() {
        System.out.println("Sending SMS notification with a message: " + getMessage());
        setDelivered(true);
        return true;
    }
}
