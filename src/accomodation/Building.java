package accomodation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Building {
    private final long id;
    private final String location;
    private final int numberOfFloors;
    private final List<Room> rooms;

    public Building(long id, String location, int numberOfFloors, List<Room> rooms) {
        this.id = id;
        this.location = location;
        this.numberOfFloors = numberOfFloors;
        this.rooms = rooms;
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public double getOccupancyRate() {
        if (rooms.isEmpty()) {
            return 0.0;
        }

        int occupiedRooms = 0;
        for (Room room : rooms) {
            if (!room.isAvailable()) {
                occupiedRooms++;
            }
        }

        return (double) occupiedRooms / rooms.size();
    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return id == building.id && numberOfFloors == building.numberOfFloors && Objects.equals(location, building.location) && Objects.equals(rooms, building.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, numberOfFloors, rooms);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", rooms=" + rooms.toString() +
                '}';
    }
}
