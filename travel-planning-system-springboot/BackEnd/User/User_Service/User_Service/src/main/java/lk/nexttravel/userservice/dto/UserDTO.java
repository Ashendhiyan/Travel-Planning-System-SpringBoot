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
    private String email;
    private int nic;
    private String address;
    private String profilePic;
}
