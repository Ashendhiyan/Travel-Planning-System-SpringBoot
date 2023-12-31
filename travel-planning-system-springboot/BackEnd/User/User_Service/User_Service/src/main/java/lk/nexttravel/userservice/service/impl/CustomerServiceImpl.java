package lk.nexttravel.userservice.service.impl;

import lk.nexttravel.userservice.dto.CustomerDTO;
import lk.nexttravel.userservice.entity.Customer;
import lk.nexttravel.userservice.repo.CustomerServiceRepo;
import lk.nexttravel.userservice.service.CustomerService;
import lk.nexttravel.userservice.util.CustomerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerServiceRepo customerRepo;

    @Autowired
    CustomerConvertor convertor;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerId())){
            throw new RuntimeException(dto.getCustomerId()+" Customer Already Exists..!");
        }else {
            customerRepo.save(convertor.customerDtoToCustomerEntity(dto));
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (!customerRepo.existsById(dto.getCustomerId())){
            throw new RuntimeException(dto.getCustomerId()+" Customer Not Found..!");
        }else {
            customerRepo.save(convertor.customerDtoToCustomerEntity(dto));
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)){
            throw  new RuntimeException(id+" Customer Not Found..!");
        }
            customerRepo.deleteById(id);

    }

    @Override
    public CustomerDTO findByCustomerId(String id) {
        if (!customerRepo.existsById(id)){
            throw new RuntimeException(id+" Customer Not Found..!");
        }
        return convertor.customerEntityToCustomerDto(customerRepo.findById(id).get());
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return convertor.customerEntityListToCustomerDTOList(customerRepo.findAll());
    }


}
