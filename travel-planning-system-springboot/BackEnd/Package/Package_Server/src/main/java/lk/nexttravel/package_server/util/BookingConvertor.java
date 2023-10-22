package lk.nexttravel.package_server.util;

import lk.nexttravel.package_server.dto.BookingDTO;
import lk.nexttravel.package_server.dto.PackageDTO;
import lk.nexttravel.package_server.entity.Booking;
import lk.nexttravel.package_server.entity.Package;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingConvertor {
     @Autowired
    ModelMapper modelMapper;

     public Booking bookingDtoToBookingEntity(BookingDTO bookingDTO){
         return modelMapper.map(bookingDTO,Booking.class);
     }

     public BookingDTO bookigEntityToBookingDto(Booking booking){
         return modelMapper.map(booking,BookingDTO.class);
     }

    public List<BookingDTO> bookingEntityListToBookingDTOList(List<Booking> bookings){
        return modelMapper.map(bookings,new TypeToken<List<BookingDTO>>(){}.getType());
    }
}
