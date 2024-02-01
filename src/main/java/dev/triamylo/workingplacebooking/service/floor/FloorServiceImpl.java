package dev.triamylo.workingplacebooking.service.floor;

import dev.triamylo.workingplacebooking.model.Floor;
import dev.triamylo.workingplacebooking.repository.FloorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The FloorServiceImpl class provides implementations for the FloorService interface.
 */
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

    /**
     * Adds a new floor to the floor repository.
     *
     * @param floor The floor object to be added.
     */
    @Override
    public void add(Floor floor) {
        floorRepository.save(floor);
    }

    /**
     * Deletes the given floor.
     *
     * @param floor The floor to be deleted.
     * @return true if the floor is successfully deleted, false otherwise.
     */
    @Override
    public boolean delete(Floor floor) {

        if (get(floor.getId()) == null) {
            return false;
        }

        floorRepository.delete(floor);
        return true;
    }

    /**
     * Updates the information of an existing floor.
     *
     * @param floor The floor object with updated information.
     * @return true if the floor is successfully updated, false otherwise.
     */
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
