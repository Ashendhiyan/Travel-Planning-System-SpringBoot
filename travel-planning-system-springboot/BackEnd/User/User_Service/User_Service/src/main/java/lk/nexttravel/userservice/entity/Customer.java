package lk.nexttravel.userservice.entity;

import jakarta.persistence.Column;
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
    private String customerId;
    private String name;
    private String email;
    private String address;
    private String nic;
    private String username;
    private String password;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
}

