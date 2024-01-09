package dev.triamylo.workingplacebooking.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private String id;
    private String name;
    private String description;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
