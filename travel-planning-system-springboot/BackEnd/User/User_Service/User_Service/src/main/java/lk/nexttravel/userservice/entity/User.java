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
public class User {
    @Id
    private String id;
    private String userName;
    private int age;
    private String email;
    private String gender;
    private int nic;
    private String address;
    private String contactNumber;
    private String role;
}
