package lk.nexttravel.hotel_server.service;

import lk.nexttravel.hotel_server.dto.HotelDTO;

public interface HotelService {
    void saveHotel(HotelDTO dto);
    void updateHotel(HotelDTO dto);
    void deleteHotel(String id);

    HotelDTO findHotelById(String id);
}
