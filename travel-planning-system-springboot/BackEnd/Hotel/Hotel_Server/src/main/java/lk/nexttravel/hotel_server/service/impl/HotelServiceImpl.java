package lk.nexttravel.hotel_server.service.impl;

import lk.nexttravel.hotel_server.dto.HotelDTO;
import lk.nexttravel.hotel_server.entity.Hotel;
import lk.nexttravel.hotel_server.repo.HotelRepo;
import lk.nexttravel.hotel_server.service.HotelService;
import lk.nexttravel.hotel_server.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    Convertor convertor;

    @Override
    public void saveHotel(HotelDTO dto) {
        if (hotelRepo.existsById(dto.getId())){
            new RuntimeException(dto.getId()+" Hotel Already Exists..!");
        }else {
            hotelRepo.save(convertor.hotelDtoToHotelEntity(dto));
        }
    }

    @Override
    public void updateHotel(HotelDTO dto) {
        if (!hotelRepo.existsById(dto.getId())){
            new RuntimeException(dto.getId()+" Hotel Not Found..!");
        }else {
            hotelRepo.save(convertor.hotelDtoToHotelEntity(dto));
        }
    }

    @Override
    public void deleteHotel(String id) {
        if (!hotelRepo.existsById(id)){
            new RuntimeException(id+" Hotel Not Found..!");
        }
        hotelRepo.deleteById(id);
    }

    @Override
    public HotelDTO findHotelById(String id) {
        if (!hotelRepo.existsById(id)){
            new RuntimeException(id+" Hotel Not Found..!");
        }
        return convertor.hotelEntityToHotelDto( hotelRepo.findById(id).get());
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return convertor.hotelEntityListToHotelDTOList(  hotelRepo.findAll());
    }
}
