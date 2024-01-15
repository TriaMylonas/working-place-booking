package dev.triamylo.workingplacebooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkDesk {

    @Id()
    @UuidGenerator
    private String id;
    private int number;
    private String description;

    public WorkDesk(int number, String description) {
        this.number = number;
        this.description = description;
    }
}
