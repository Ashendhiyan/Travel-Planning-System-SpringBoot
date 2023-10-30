package lk.nexttravel.hotel_server.api;

import lk.nexttravel.hotel_server.dto.HotelDTO;
import lk.nexttravel.hotel_server.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelApi {

    @Autowired
    HotelService hotelService;

  /*  @PostMapping
    public ResponseEntity<String> saveHotel(@RequestBody HotelDTO hotelDTO){
        hotelService.saveHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO.getHotelId()+" Hotel Saved..!", HttpStatus.OK);
    }*/

    @PostMapping
    public  ResponseEntity<String> saveHotel(
            @RequestParam("hotelId") String hotelId,
            @RequestParam("hotelLocation") String hotelLocation,
            @RequestParam("hotelName") String hotelName,
            @RequestParam("coordinates") String coordinates,
            @RequestParam("roomType") String roomType,
            @RequestParam("starRate") String starRate,
            @RequestParam("packageCategory") String packageCategory,
            @RequestParam("hotelContactNumber") String hotelContactNumber,
            @RequestParam("petsAllowedOrNot") boolean petsAllowedOrNot,
            @RequestParam("cancelCriteria") String cancelCriteria,
            @RequestParam("remarks") String remarks,
            @RequestParam("hotelFee") double hotelFee,
            @RequestParam("email") String email,
            @RequestParam("image") String image
    ){
        try{
            hotelService.saveHotel(new HotelDTO(
                    hotelId,
                    hotelLocation,
                    hotelName,
                    coordinates,
                    roomType,
                    starRate,
                    packageCategory,
                    hotelContactNumber,
                    petsAllowedOrNot,
                    cancelCriteria,
                    remarks,
                    hotelFee,
                    email,
                    Base64.getEncoder().encodeToString(image.getBytes())
            ));
        }catch (Exception e){
            throw new RuntimeException("Image Not Found..!");
        }
        return new ResponseEntity<>(hotelId+" Hotel Saved..!",HttpStatus.OK);
    }



    @PutMapping
    public  ResponseEntity<String> updateHotel(
            @RequestParam("hotelId") String hotelId,
            @RequestParam("hotelLocation") String hotelLocation,
            @RequestParam("hotelName") String hotelName,
            @RequestParam("coordinates") String coordinates,
            @RequestParam("roomType") String roomType,
            @RequestParam("starRate") String starRate,
            @RequestParam("packageCategory") String packageCategory,
            @RequestParam("hotelContactNumber") String hotelContactNumber,
            @RequestParam("petsAllowedOrNot") boolean petsAllowedOrNot,
            @RequestParam("cancelCriteria") String cancelCriteria,
            @RequestParam("remarks") String remarks,
            @RequestParam("hotelFee") double hotelFee,
            @RequestParam("email") String email,
            @RequestParam("image") String image
    ){
        try{
            hotelService.updateHotel(new HotelDTO(
                    hotelId,
                    hotelLocation,
                    hotelName,
                    coordinates,
                    roomType,
                    starRate,
                    packageCategory,
                    hotelContactNumber,
                    petsAllowedOrNot,
                    cancelCriteria,
                    remarks,
                    hotelFee,
                    email,
                    Base64.getEncoder().encodeToString(image.getBytes())
            ));
        }catch (Exception e){
            throw new RuntimeException("Image Not Found..!");
        }
        return new ResponseEntity<>(hotelId+" Hotel Updated..!",HttpStatus.OK);
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

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels(){
        return new ResponseEntity<>(hotelService.getAllHotels(),HttpStatus.OK);
    }


  /*  @GetMapping
    public ResponseEntity<String> getApi(){
        return new ResponseEntity<>("Hotel Api is Ok",HttpStatus.OK);
    }*/

}
