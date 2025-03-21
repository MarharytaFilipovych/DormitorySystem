package requests;

import enums.RequestPriority;
import enums.Status;

import java.util.Objects;

public class ChangeRoomRequest extends Request{
    private final int newRoomId;
    private final int oldRoomId;

    public ChangeRoomRequest(long id, long studentId, String description, Status status, RequestPriority priority, int newRoomId, int oldRoomId) {
        super(id, studentId, description, status, priority);
        this.newRoomId = newRoomId;
        this.oldRoomId = oldRoomId;
    }

    public int getNewRoomId() {
        return newRoomId;
    }

    public int getOldRoomId() {
        return oldRoomId;
    }

    @Override
    public boolean makeRequest() {
        System.out.println("Creating room change request from room " + oldRoomId + " to room " + newRoomId);
        return true;
    }

    public boolean processTransfer() {
        System.out.println("Processing transfer from room " + oldRoomId + " to room " + newRoomId + " for student with ID "+ studentId);
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChangeRoomRequest that = (ChangeRoomRequest) o;
        return newRoomId == that.newRoomId && oldRoomId == that.oldRoomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), newRoomId, oldRoomId);
    }

    @Override
    public String toString() {
        return "ChangeRoomRequest{" +
                "newRoomId=" + newRoomId +
                ", oldRoomId=" + oldRoomId +
                ", id=" + id +
                ", studentId=" + studentId +
                ", requestDate=" + requestDate +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
