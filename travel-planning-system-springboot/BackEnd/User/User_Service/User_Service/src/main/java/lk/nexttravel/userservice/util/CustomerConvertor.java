package lk.nexttravel.userservice.util;

import lk.nexttravel.userservice.dto.CustomerDTO;
import lk.nexttravel.userservice.dto.UserDTO;
import lk.nexttravel.userservice.entity.Customer;
import lk.nexttravel.userservice.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerConvertor {
    @Autowired
    ModelMapper modelMapper;

    public Customer customerDtoToCustomerEntity(CustomerDTO dto){
        return modelMapper.map(dto,Customer.class);
    }

    public CustomerDTO customerEntityToCustomerDto(Customer customer){
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> customerEntityListToCustomerDTOList(List<Customer> customers){
        return modelMapper.map(customers,new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
