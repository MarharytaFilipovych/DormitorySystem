package notifications;

import enums.NotificationType;

public class EmailNotification extends Notification{
    public EmailNotification(long id, String message, NotificationType type) {
        super(id,  message, type);
    }
    @Override
    public boolean send() {
        System.out.println("Sending email notification with a message: " + getMessage());
        setDelivered(true);
        return true;
    }

}
