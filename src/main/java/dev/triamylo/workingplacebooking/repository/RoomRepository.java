package dev.triamylo.workingplacebooking.repository;

import dev.triamylo.workingplacebooking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {
}
