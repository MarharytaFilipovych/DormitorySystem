package accomodation;

import user.Student;

import java.util.HashMap;
import java.util.Map;

public class AccommodationService {
    private Map<Room, Student> assignments;

    public AccommodationService() {
        this.assignments = new HashMap<>();
    }

    public boolean assignRoom(Student student, Room room) {
        if (room.isAvailable()) {
            assignments.put(room, student);
            room.setAvailable(false);
            student.setResident(true);
            return true;
        }
        return false;
    }

    public boolean unassignRoom(Student student, Room room) {
        if (assignments.containsKey(room) && assignments.get(room).getId() == student.getId()) {
            assignments.remove(room);
            room.setAvailable(true);
            student.setResident(false);
            return true;
        }
        return false;
    }

    public boolean changeRoom(Student student, Room newRoom) {
        Room currentRoom = getAssignedRoom(student);
        if (currentRoom != null && newRoom.isAvailable()) {
            unassignRoom(student, currentRoom);
            assignRoom(student, newRoom);
            return true;
        }
        return false;
    }

    public Room getAssignedRoom(Student student) {
        for (Map.Entry<Room, Student> entry : assignments.entrySet()) {
            if (entry.getValue().getId() == student.getId()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Map<Room, Student> getAssignments() { return assignments; }
}
