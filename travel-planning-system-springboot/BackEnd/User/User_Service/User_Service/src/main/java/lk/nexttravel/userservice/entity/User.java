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
    private String userId;
    private String name;
    private String nic;
    private int age;
    private String gender;
    private String email;
    private String contactNumber;
    private String address;
    private String role;
}
