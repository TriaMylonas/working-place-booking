package dev.triamylo.workingplacebooking.service;

import dev.triamylo.workingplacebooking.model.Floor;
import dev.triamylo.workingplacebooking.repository.FloorRepository;
import dev.triamylo.workingplacebooking.service.floor.FloorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class FloorServiceImplTest {
    private final FloorRepository floorRepository = Mockito.mock(FloorRepository.class);
    private final FloorServiceImpl floorService = new FloorServiceImpl(floorRepository);

    @Test
    void testGetWithValidId() {
        Floor mockFloor = new Floor();
        mockFloor.setId("123");
        when(floorRepository.findById("123")).thenReturn(Optional.of(mockFloor));

        Floor result = floorService.get("123");
        assertEquals(mockFloor, result);
    }

    @Test
    void testGetWithInvalidId() {
        when(floorRepository.findById("456")).thenReturn(Optional.empty());

        Floor result = floorService.get("456");
        assertNull(result);
    }
}