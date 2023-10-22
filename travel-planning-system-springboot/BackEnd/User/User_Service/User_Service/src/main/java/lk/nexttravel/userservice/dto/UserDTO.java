package lk.nexttravel.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
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
