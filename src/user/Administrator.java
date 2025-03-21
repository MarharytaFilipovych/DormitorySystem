package user;

import application.Application;
import requests.Request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Administrator extends User{
    List<Staff> staff;

    public Administrator(long id, String name, String surname, String email, String phoneNumber, Date dateOfBirth, String address, String password) {
        super(id, name, surname, email, phoneNumber, dateOfBirth, address, password);
        staff = new ArrayList<>();
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
    public boolean addStaffMember(Staff staffMember) {
        if(staff.contains(staffMember))return false;
        staff.add(staffMember);
        System.out.println("Staff account created for: " + staffMember.getName() + " " + staffMember.getSurname() + ". ID: " + staffMember.getId());
        return true;
    }
    public boolean createStudentAccount(Student student) {
        System.out.println("Student account created for: " + student.getName() + " " + student.getSurname() + ". ID: " + student.getId());        return true;
    }

    public boolean updateStudentAccount(long studentId, Student updatedDetails) {
        System.out.println("Student account updated  a student with ID" + studentId);
        return true;
    }

    public boolean deleteStudentAccount(long studentId) {
        System.out.println("Student account deleted for a student with ID " + studentId);
        return true;
    }

    public void reviewApplication(Application application) {
        System.out.println("application.Application " + application.getId() + " reviewed");
        application.approve();
    }

    public void assignRequest(Request request) {
        // pick staff member
        Random random = new Random();
        staff.get(random.nextInt(staff.size())).addAssignedRequest(request);
        System.out.println("Request " + request.getId() + " assigned to staff");
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                '}';
    }
}

