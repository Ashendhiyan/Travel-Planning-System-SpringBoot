package lk.nexttravel.package_server.service.impl;

import lk.nexttravel.package_server.dto.BookingDTO;
import lk.nexttravel.package_server.entity.Booking;
import lk.nexttravel.package_server.repo.BookingServiceRepo;
import lk.nexttravel.package_server.service.BookingService;
import lk.nexttravel.package_server.util.BookingConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingServiceRepo bookingRepo;

    @Autowired
    BookingConvertor convertor;

    @Override
    public void saveBooking(BookingDTO dto) {
        if (bookingRepo.existsById(dto.getBookingId())) {
            throw new RuntimeException(dto.getBookingId() + " Booking Saved..!");
        } else{
            bookingRepo.save(convertor.bookingDtoToBookingEntity(dto));
        }
    }

    @Override
    public void updateBooking(BookingDTO dto) {
        if (!bookingRepo.existsById(dto.getBookingId())){
            throw new RuntimeException(dto.getBookingId()+" Booking Not Found..!");
        }else {
            bookingRepo.save(convertor.bookingDtoToBookingEntity(dto));
        }
    }

    @Override
    public void deleteBooking(String id) {
        if (!bookingRepo.existsById(id)){
            throw new RuntimeException(id+" Not Found..!");
        }
        bookingRepo.deleteById(id);
    }

    @Override
    public BookingDTO findByBookingId(String id) {
        if (!bookingRepo.existsById(id)){
            throw new RuntimeException(id+" Booking not Found..!");
        }
        return convertor.bookigEntityToBookingDto(bookingRepo.findById(id).get());
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return convertor.bookingEntityListToBookingDTOList(bookingRepo.findAll());
    }

}
