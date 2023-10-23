package lk.nexttravel.userservice.util;

import lk.nexttravel.userservice.dto.CustomerDTO;
import lk.nexttravel.userservice.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
