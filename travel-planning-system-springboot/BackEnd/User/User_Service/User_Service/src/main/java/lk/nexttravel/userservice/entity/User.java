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
    private String email;
    private int nic;
    private String address;
    private String profilePic;
}
