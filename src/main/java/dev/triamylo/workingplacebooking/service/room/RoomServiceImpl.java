package dev.triamylo.workingplacebooking.service.room;

import dev.triamylo.workingplacebooking.model.Room;
import dev.triamylo.workingplacebooking.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> list() {
        return roomRepository.findAll();
    }

    @Override
    public Room get(String id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Room room) {
        roomRepository.save(room);
    }

    @Override
    public boolean delete(Room room) {
        Optional<Room> existingRoom = roomRepository.findById(room.getId());

        if (existingRoom.isPresent()) {
            roomRepository.delete(room);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Room room) {

        Optional<Room> existingRoom = roomRepository.findById(room.getId());

        if (existingRoom.isPresent()) {
            Room updatedRoom = existingRoom.get();
            updatedRoom.setNumber(room.getNumber());
            updatedRoom.setDescription(room.getDescription());
            roomRepository.save(updatedRoom);
            return true;
        }

        return false;
    }
}
