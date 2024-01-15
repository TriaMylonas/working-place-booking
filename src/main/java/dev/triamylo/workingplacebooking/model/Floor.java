package dev.triamylo.workingplacebooking.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Floor {

    @Id()
    @UuidGenerator
    private String id;
    private int number;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
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
