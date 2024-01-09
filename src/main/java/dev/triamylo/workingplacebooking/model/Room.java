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
public class Room {

    private String id;
    private int number;
    private String description;
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
