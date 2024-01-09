package dev.triamylo.workingplacebooking.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    private String id;
    private Date day;
    private User whoBooked;
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
