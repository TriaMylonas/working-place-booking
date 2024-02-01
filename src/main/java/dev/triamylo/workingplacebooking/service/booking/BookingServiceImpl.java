package dev.triamylo.workingplacebooking.service.booking;

import dev.triamylo.workingplacebooking.model.Booking;
import dev.triamylo.workingplacebooking.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public List<Booking> list() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking get(String id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public boolean update(Booking booking) {

        Booking existingBooking = get(booking.getId());

        if (existingBooking != null) {
            existingBooking.setDay(booking.getDay());
            existingBooking.setWhoBooked(booking.getWhoBooked());
            existingBooking.setWorkDesk(booking.getWorkDesk());
            bookingRepository.save(existingBooking);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Booking booking) {
        if (bookingExist(booking.getId())) {
            bookingRepository.delete(booking);
            return true;
        }
        return false;
    }


    private boolean bookingExist(String id) {
        return get(id) != null;
    }
}