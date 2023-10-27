package lk.nexttravel.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String customerId;
    private String name;
    private String email;
    private String address;
    private String nic;
    private String username;
    private String password;
    private String profilePic;
}

