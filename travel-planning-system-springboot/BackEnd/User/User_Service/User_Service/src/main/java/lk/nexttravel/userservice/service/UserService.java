package lk.nexttravel.userservice.service;

import lk.nexttravel.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {

    void saveUser(UserDTO dto);
    void updateUser(UserDTO dto);
    UserDTO findById (String id);
    void deleteUser(String id);
    List<UserDTO> getAll();
}
