package dev.triamylo.workingplacebooking.service;

import dev.triamylo.workingplacebooking.model.Floor;
import dev.triamylo.workingplacebooking.repository.FloorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {

    private final FloorRepository floorRepository;

    public FloorServiceImpl(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }


    @Override
    public List<Floor> list() {
        return floorRepository.findAll();
    }

    @Override
    public Floor get(String id) {
        return floorRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Floor floor) {
        floorRepository.save(floor);
    }

    @Override
    public boolean delete(Floor floor) {

        if (get(floor.getId()) == null) {
            return false;
        }

        floorRepository.delete(floor);
        return true;
    }

    @Override
    public boolean update(Floor floor) {

        Floor existingFloor = get(floor.getId());

        if (existingFloor == null) {
            return false;
        }

        existingFloor.setNumber(floor.getNumber());
        existingFloor.setDescription(floor.getDescription());
        existingFloor.setRooms(floor.getRooms());

        floorRepository.save(existingFloor);
        return true;
    }
}
