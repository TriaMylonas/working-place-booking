package dev.triamylo.workingplacebooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDesk {

    private String id;
    private int number;
    private String description;

    public WorkDesk(int number, String description) {
        this.number = number;
        this.description = description;
    }
}
