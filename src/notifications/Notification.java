package notifications;

import enums.NotificationType;

import java.util.Objects;

public abstract class Notification {
    protected long id;
    protected boolean isRead = false;
    protected boolean isDelivered = false;
    protected String message;
    protected NotificationType type;

    public Notification(long id, String message, NotificationType type) {
        this.id = id;
        this.message = message;
        this.type = type;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", isRead=" + isRead +
                ", isDelivered=" + isDelivered +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id == that.id && isRead == that.isRead && isDelivered == that.isDelivered && Objects.equals(message, that.message) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isRead, isDelivered, message, type);
    }
    public abstract boolean send();

}


