package lk.nexttravel.package_server.service;

import lk.nexttravel.package_server.dto.BookingDTO;

public interface BookingService {
    void saveBooking(BookingDTO dto);
    void updateBooking(BookingDTO dto);
    void deleteBooking(String id);
    BookingDTO findByBookingId(String id);
}
