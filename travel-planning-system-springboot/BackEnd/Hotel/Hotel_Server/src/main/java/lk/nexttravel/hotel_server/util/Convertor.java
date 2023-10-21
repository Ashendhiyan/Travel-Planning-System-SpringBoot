package lk.nexttravel.hotel_server.util;

import lk.nexttravel.hotel_server.dto.HotelDTO;
import lk.nexttravel.hotel_server.entity.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Convertor {

    @Autowired
    ModelMapper modelMapper;


    public Hotel hotelDtoToHotelEntity(HotelDTO hotelDTO){
        return modelMapper.map(hotelDTO, Hotel.class);
    }

    public HotelDTO hotelEntityToHotelDto(Hotel hotel){
        return modelMapper.map(hotel, HotelDTO.class);
    }
}
