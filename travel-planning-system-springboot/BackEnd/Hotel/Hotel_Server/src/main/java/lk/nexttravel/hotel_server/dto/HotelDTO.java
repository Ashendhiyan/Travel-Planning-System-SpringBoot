package lk.nexttravel.hotel_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO {
    private String hotelId;
    private String hotelLocation;
    private String hotelName;
    private String coordinates;
    private String roomType;
    private String starRate;
    private String packageCategory;
    private String hotelContactNumber;
    private  boolean petsAllowedOrNot;
    private  String cancelCriteria;
    private  String remarks;
    private  double hotelFee;
    private String email;
    private String image;
}
