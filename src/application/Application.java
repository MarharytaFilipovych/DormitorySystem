package application;

import accomodation.Room;
import enums.Status;

import java.util.Date;
import java.util.List;

public class Application {
    private final long id;
    private final long studentId;
    private final Date applicationDate;
    private List<Room> preferences;
    private Status status;

    public Application(long id, long studentId, List<Room> preferences, Status status) {
        this.id = id;
        this.studentId = studentId;
        this.applicationDate = new Date();
        this.preferences = preferences;
        this.status = status;
    }

    public boolean submit() {
        System.out.println("Application submitted with ID: " + id);
        return true;
    }

    public boolean approve() {
        status = Status.APPROVED;
        System.out.println("Application " + id + " approved");
        return true;
    }

    public boolean reject(String reason) {
        status = Status.REJECTED;
        System.out.println("Application " + id + " rejected. Reason: " + reason);
        return true;
    }

    public boolean addToWaitlist() {
        status = Status.WAITLISTED;
        System.out.println("Application " + id + " added to waitlist");
        return true;
    }

    public long getId() {
        return id;
    }

    public long getStudentId() {
        return studentId;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public List<Room> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Room> preferences) {
        this.preferences = preferences;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", applicationDate=" + applicationDate +
                ", preferences=" + preferences.toString() +
                ", status=" + status +
                '}';
    }
}
