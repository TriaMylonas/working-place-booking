package dev.triamylo.workingplacebooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {

    @Id()
    @UuidGenerator
    private String id;
    private int number;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WorkDesk> workDesks;

    public Room(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public void addWorkDesk(WorkDesk workDesk) {
        workDesks.add(workDesk);
    }

    public void removeWorkDesk(WorkDesk workDesk) {
        workDesks.remove(workDesk);
    }
}
