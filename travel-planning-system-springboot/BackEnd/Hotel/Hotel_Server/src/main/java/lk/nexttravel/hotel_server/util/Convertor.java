package lk.nexttravel.hotel_server.util;

import lk.nexttravel.hotel_server.dto.HotelDTO;
import lk.nexttravel.hotel_server.entity.Hotel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<HotelDTO> hotelEntityListToHotelDTOList(List<Hotel> hotels){
        return modelMapper.map(hotels,new TypeToken<List<HotelDTO>>(){}.getType());
    }
}
