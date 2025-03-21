package user;

import notifications.Notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Student extends User{
    private String program;
    private int year;
    private boolean isResident = false;
    private List<Notification> notifications;

    public Student(long id, String name, String surname, String email, String phoneNumber, Date dateOfBirth, String address, String password, String program, int year) {
        super(id, name, surname, email, phoneNumber, dateOfBirth, address, password);
        this.program = program;
        this.year = year;
        notifications = new ArrayList<>();
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public boolean isResident() {
        return isResident;
    }

    public void setResident(boolean resident) {
        isResident = resident;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return year == student.year && isResident == student.isResident && Objects.equals(program, student.program) && Objects.equals(notifications, student.notifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), program, year, isResident, notifications);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", program='" + program + '\'' +
                ", year=" + year +
                ", isResident=" + isResident +
                ", notifications=" + notifications +
                '}';
    }
}
