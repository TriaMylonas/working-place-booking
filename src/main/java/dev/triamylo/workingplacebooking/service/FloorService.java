package dev.triamylo.workingplacebooking.service;

import dev.triamylo.workingplacebooking.model.Floor;

import java.util.List;

public interface FloorService {
    List<Floor> list();

    Floor get(String id);

    void add(Floor floor);

    boolean delete(Floor floor);

    boolean update(Floor floor);

}
