package lk.nexttravel.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
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
