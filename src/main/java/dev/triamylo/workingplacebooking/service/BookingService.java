package dev.triamylo.workingplacebooking.service;

import dev.triamylo.workingplacebooking.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> list();

    Booking get(String id);

    void add(Booking booking);

    boolean delete(Booking booking);

    boolean update(Booking booking);

}
