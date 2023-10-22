package lk.nexttravel.package_server.api;

import lk.nexttravel.package_server.dto.BookingDTO;
import lk.nexttravel.package_server.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingApi {

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> saveBooking(@RequestBody BookingDTO bookingDTO){
        bookingService.saveBooking(bookingDTO);
        return new ResponseEntity<>(bookingDTO.getBookingId()+" Booking Saved..!", HttpStatus.OK);
    }


}
