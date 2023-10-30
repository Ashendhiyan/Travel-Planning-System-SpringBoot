package lk.nexttravel.userservice.api;

import lk.nexttravel.userservice.dto.CustomerDTO;
import lk.nexttravel.userservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerApi {
    @Autowired
    CustomerService customerService;


    @PostMapping
    public ResponseEntity<String> saveCustomer(
            @RequestParam("customerId") String customerId,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("nic") String nic,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("profilePic") String profilePic
    ){
        try {
        customerService.saveCustomer(new CustomerDTO(
                customerId,
                name,
                email,
                address,
                nic,
                username,
                password,
                Base64.getEncoder().encodeToString(profilePic.getBytes())
        ));
        }catch (Exception e){
            throw new RuntimeException("Image not Found..!");
        }
        return new ResponseEntity<>(customerId+" Customer Saved..!",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(
            @RequestParam("customerId") String customerId,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("nic") String nic,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("profilePic") String profilePic
    ){
        try {
            customerService.updateCustomer(new CustomerDTO(
                    customerId,
                    name,
                    email,
                    address,
                    nic,
                    username,
                    password,
                    Base64.getEncoder().encodeToString(profilePic.getBytes())
            ));
        }catch (Exception e){
            throw new RuntimeException("Image not Found..!");
        }
        return new ResponseEntity<>(customerId+" Customer Updated..!",HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteCustomer(String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(id+" Customer Deleted..!",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<CustomerDTO> findCustomerById(String id){
        return new ResponseEntity<>(customerService.findByCustomerId(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

  /*  @GetMapping
    public ResponseEntity<String> getApi(){
        return new ResponseEntity<>("Customer Api is Ok",HttpStatus.OK);
    }*/

}
