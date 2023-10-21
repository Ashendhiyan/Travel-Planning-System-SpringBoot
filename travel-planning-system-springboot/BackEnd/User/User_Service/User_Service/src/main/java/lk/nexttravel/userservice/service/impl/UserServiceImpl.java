package lk.nexttravel.userservice.service.impl;

import lk.nexttravel.userservice.dto.UserDTO;
import lk.nexttravel.userservice.entity.User;
import lk.nexttravel.userservice.repo.UserRepo;
import lk.nexttravel.userservice.service.UserService;
import lk.nexttravel.userservice.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    Convertor convertor;
    @Override
    public void saveUser(UserDTO dto) {
        if (userRepo.existsById(dto.getId())){
             new RuntimeException(dto.getId()+"User Already Exists..!");
        }
        userRepo.save(convertor.userDtoToUserEntity(dto));
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (!userRepo.existsById(dto.getId())){
            new RuntimeException(dto.getId()+" Not Found..");
        }
        userRepo.save(convertor.userDtoToUserEntity(dto));
    }

    @Override
    public UserDTO findById(String id) {
        if(!userRepo.existsById(id)){
            new RuntimeException(id+" Not Found..!");
        }
        return convertor.userEntityToUserDto(userRepo.findById(id).get());
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepo.existsById(id)){
            new RuntimeException(id+"User not found");
        }
        userRepo.deleteById(id);
    }

    @Override
    public List<UserDTO> getAll() {
        return convertor.userEntityListToUserDTOList(userRepo.findAll());
    }

}
