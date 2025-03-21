package user;

import enums.Status;
import requests.Request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Staff extends  User{
    private List<Request> assignedRequests;

    public Staff(long id, String name, String surname, String email, String phoneNumber, Date dateOfBirth, String address, String password) {
        super(id, name, surname, email, phoneNumber, dateOfBirth, address, password);
        this.assignedRequests = new ArrayList<>();
    }

    public List<Request> getAssignedRequests() {
        return assignedRequests;
    }

    public void setAssignedRequests(List<Request> assignedRequests) {
        this.assignedRequests = assignedRequests;
    }

    public void addAssignedRequest(Request request) {
        assignedRequests.add(request);
    }

    public void processRequest(long requestId) {
        Request request = findRequestById(requestId);
        if (request != null) {
            System.out.println("Processing request: " + requestId);
            updateRequestStatus(requestId, Status.COMPLETED);
        }
    }

    public boolean updateRequestStatus(long requestId, Status status) {
        Request request = findRequestById(requestId);
        if (request != null) {
            request.updateStatus(status);
            System.out.println("Request " + requestId + " status updated to: " + status);
            return true;
        }
        return false;
    }

    private Request findRequestById(long requestId) {
        for (Request request : assignedRequests) {
            if (request.getId() == requestId) {
                return request;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                '}';
    }
}
