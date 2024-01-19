package dev.triamylo.workingplacebooking.model.dto;

import dev.triamylo.workingplacebooking.model.Booking;
import dev.triamylo.workingplacebooking.model.WorkDesk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDeskBookingList {


    private List<WorkDesk> workDesks;
    private List<Booking> bookings;
    private boolean workDeskAvailable;
    private Date day;

}
