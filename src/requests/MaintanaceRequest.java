package requests;

import enums.RequestPriority;
import enums.Status;

import java.util.Objects;

public class MaintanaceRequest extends Request{
    private final String utilityInQuestion;

    public MaintanaceRequest(long id, long studentId, String description, Status status, RequestPriority priority, String utilityInQuestion) {
        super(id, studentId, description, status, priority);
        this.utilityInQuestion = utilityInQuestion;
    }

    public String getUtilityInQuestion() {
        return utilityInQuestion;
    }

    @Override
    public boolean makeRequest() {
        System.out.println("Creating maintenance request for utility: " + utilityInQuestion);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MaintanaceRequest that = (MaintanaceRequest) o;
        return Objects.equals(utilityInQuestion, that.utilityInQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), utilityInQuestion);
    }

    @Override
    public String toString() {
        return "MaintanaceRequest{" +
                "utilityInQuestion='" + utilityInQuestion + '\'' +
                ", id=" + id +
                ", studentId=" + studentId +
                ", requestDate=" + requestDate +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
