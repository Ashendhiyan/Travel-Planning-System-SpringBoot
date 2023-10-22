package lk.nexttravel.package_server.util;

import lk.nexttravel.package_server.dto.BookingDTO;
import lk.nexttravel.package_server.entity.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingConvertor {
     @Autowired
    ModelMapper modelMapper;

     public Booking bookingDtoToBookingEntity(BookingDTO bookingDTO){
         return modelMapper.map(bookingDTO,Booking.class);
     }
}
