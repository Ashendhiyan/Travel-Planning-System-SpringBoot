package lk.nexttravel.userservice.service;

import lk.nexttravel.userservice.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
    CustomerDTO findByCustomerId(String id);
    List<CustomerDTO> getAllCustomers();
}
