package lk.nexttravel.hotel_server.service.impl;

import lk.nexttravel.hotel_server.dto.HotelDTO;
import lk.nexttravel.hotel_server.repo.HotelRepo;
import lk.nexttravel.hotel_server.service.HotelService;
import lk.nexttravel.hotel_server.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        }
        hotelRepo.save(convertor.hotelDtoToHotelEntity(dto));
    }
}
