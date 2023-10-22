package lk.nexttravel.userservice.api;

import lk.nexttravel.userservice.dto.CustomerDTO;
import lk.nexttravel.userservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerApi {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(customerDTO.getId()+" Customer Saved..!", HttpStatus.OK);
    }
}
