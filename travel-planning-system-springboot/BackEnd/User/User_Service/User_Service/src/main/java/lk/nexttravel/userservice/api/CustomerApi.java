package lk.nexttravel.userservice.api;

import lk.nexttravel.userservice.dto.CustomerDTO;
import lk.nexttravel.userservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDTO customer){
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(customer.getId()+" Customer Updated..!",HttpStatus.OK);
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
}
