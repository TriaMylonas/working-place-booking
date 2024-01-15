package dev.triamylo.workingplacebooking.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {

    @Id()
    @UuidGenerator
    private String id;

    private Date day;

    @ManyToOne(cascade = CascadeType.ALL)
    private User whoBooked;
    @ManyToOne(cascade = CascadeType.ALL)
    private WorkDesk workDesk;

    public Booking(Date day, User whoBooked, WorkDesk workDesk) {
        this.day = day;
        this.whoBooked = whoBooked;
        this.workDesk = workDesk;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", day=" + day +
                ", whoBooked=" + whoBooked +
                ", workDesk=" + workDesk +
                '}';
    }

}
