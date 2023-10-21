package lk.nexttravel.hotel_server.service;

import lk.nexttravel.hotel_server.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    void saveHotel(HotelDTO dto);
    void updateHotel(HotelDTO dto);
    void deleteHotel(String id);
    HotelDTO findHotelById(String id);
    List<HotelDTO> getAllHotels();
}
