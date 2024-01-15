package dev.triamylo.workingplacebooking.service;

import dev.triamylo.workingplacebooking.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> list();

    Room get(String id);

    void add(Room room);

    boolean delete(Room room);

    boolean update(Room room);
}
