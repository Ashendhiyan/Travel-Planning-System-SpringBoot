package lk.nexttravel.hotel_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Hotel {
    @Id
    private String id;
    private String hotelName;
    private String location;
    private String coordinates;
    private String email;
    private String number1;
    private String number2;
    private String petStats;
    private int hotelFee;
    private String cancellationCriteria;
}
