package lk.nexttravel.userservice.service;

import lk.nexttravel.userservice.dto.CustomerDTO;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
}
