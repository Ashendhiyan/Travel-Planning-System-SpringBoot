package lk.nexttravel.hotel_server.api;

import lk.nexttravel.hotel_server.dto.HotelDTO;
import lk.nexttravel.hotel_server.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelApi {

    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<String> saveHotel(@RequestBody HotelDTO hotelDTO){
        hotelService.saveHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO.getId()+" Hotel Saved..!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateHotel(@RequestBody HotelDTO hotelDTO){
        hotelService.updateHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO.getId()+" Hotel Updated..!",HttpStatus.OK);
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteHotel(String id){
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(id+" Hotel Deleted..!",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<HotelDTO> findHotelById(String id){
        return new ResponseEntity<>(hotelService.findHotelById(id),HttpStatus.OK);
    }

}
