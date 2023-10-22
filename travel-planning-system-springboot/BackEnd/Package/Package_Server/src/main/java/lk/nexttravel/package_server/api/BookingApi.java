package lk.nexttravel.package_server.api;

import lk.nexttravel.package_server.dto.BookingDTO;
import lk.nexttravel.package_server.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public ResponseEntity<String> updateBooking(@RequestBody BookingDTO bookingDTO){
        bookingService.updateBooking(bookingDTO);
        return new ResponseEntity<>(bookingDTO.getBookingId()+" Booking Updated..!",HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteBookingById(String id){
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(id+" Booking Deleted..!",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<BookingDTO> findBookingById(String id){
        return new ResponseEntity<>(bookingService.findByBookingId(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings(){
        return new ResponseEntity<>( bookingService.getAllBookings(),HttpStatus.OK);
    }
}
