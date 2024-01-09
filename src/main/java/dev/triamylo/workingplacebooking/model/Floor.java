package dev.triamylo.workingplacebooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Floor {

    private String id;
    private int number;
    private String description;
    private List<Room> rooms;

    public Floor(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    public void removeRoom(Room room) {
        rooms.remove(room);
    }
}
