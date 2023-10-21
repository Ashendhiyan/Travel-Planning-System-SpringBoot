package lk.nexttravel.userservice.util;

import lk.nexttravel.userservice.dto.UserDTO;
import lk.nexttravel.userservice.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Convertor {
    @Autowired
    ModelMapper modelMapper;

    public User userDtoToUserEntity(UserDTO dto){
        return modelMapper.map(dto,User.class);
    }

    public UserDTO userEntityToUserDto(User entity){
        return modelMapper.map(entity, UserDTO.class);
    }

    public List<UserDTO> userEntityListToUserDTOList(List<User> packages){
        return modelMapper.map(packages,new TypeToken<List<UserDTO>>(){}.getType());
    }
}
