package accomodation;

import enums.RoomType;

import java.util.Objects;

public class Room {
    private final long id;
    private final int floor;
    private final long roomNumber;
    private final String buildingId;
    private final RoomType type;
    private double price;
    private boolean isAvailable = true;

    public Room(long id, int floor, long roomNumber, String buildingId, RoomType type, double price) {
        this.id = id;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.buildingId = buildingId;
        this.type = type;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public RoomType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && floor == room.floor && roomNumber == room.roomNumber && Double.compare(price, room.price) == 0 && isAvailable == room.isAvailable && Objects.equals(buildingId, room.buildingId) && type == room.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, floor, roomNumber, buildingId, type, price, isAvailable);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", floor=" + floor +
                ", roomNumber=" + roomNumber +
                ", buildingId='" + buildingId + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }


}
