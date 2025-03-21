package requests;

import enums.RequestPriority;
import enums.Status;

import java.util.Date;
import java.util.Objects;

public class Request {
    protected final long id;
    protected final long studentId;
    protected final Date requestDate;
    protected String description;
    protected Status status;
    protected final RequestPriority priority;

    public Request(long id, long studentId, String description, Status status, RequestPriority priority) {
        this.id = id;
        this.studentId = studentId;
        this.requestDate = new Date();
        this.description = description;
        this.status = status;
        this.priority = priority;
    }
    public boolean makeRequest(){
        System.out.println("Creating general request: " + getDescription());
        return true;
    };

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", requestDate=" + requestDate +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }

    public long getId() {
        return id;
    }

    public long getStudentId() {
        return studentId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    public RequestPriority getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id == request.id && studentId == request.studentId && Objects.equals(requestDate, request.requestDate) && Objects.equals(description, request.description) && status == request.status && priority == request.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, requestDate, description, status, priority);
    }
}


