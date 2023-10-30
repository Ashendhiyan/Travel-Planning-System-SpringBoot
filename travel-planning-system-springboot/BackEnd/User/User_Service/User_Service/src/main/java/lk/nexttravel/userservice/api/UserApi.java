package lk.nexttravel.userservice.api;

import lk.nexttravel.userservice.dto.UserDTO;
import lk.nexttravel.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/user")
public class UserApi {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<String> saveCustomer(@RequestBody UserDTO userDTO){
        service.saveUser(userDTO);
        return new ResponseEntity<>(userDTO.getUserId()+" User Saved..!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody UserDTO userDTO){
        service.updateUser(userDTO);
        return new ResponseEntity<>(userDTO.getUserId()+" User Updated...",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<UserDTO> findById(String id){
        UserDTO data = service.findById(id);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteCustomer(String id){
        service.deleteUser(id);
        return new ResponseEntity<>(id+" User deleted..!",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        List<UserDTO> all = service.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

/*    @GetMapping
    public ResponseEntity<String> getApi(){
        return new ResponseEntity<>("User Api is Ok",HttpStatus.OK);
    }*/

}
