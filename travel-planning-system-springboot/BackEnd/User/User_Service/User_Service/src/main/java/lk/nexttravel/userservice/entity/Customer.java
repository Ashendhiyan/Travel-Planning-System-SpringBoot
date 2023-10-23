package lk.nexttravel.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private String id;
    private String userName;
    private String address;
    private int age;
    private String email;
    private String gender;
    private int nic;
    private String contactNumber;
}
