package lk.nexttravel.userservice.service.impl;

import lk.nexttravel.userservice.dto.CustomerDTO;
import lk.nexttravel.userservice.repo.CustomerServiceRepo;
import lk.nexttravel.userservice.service.CustomerService;
import lk.nexttravel.userservice.util.CustomerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerServiceRepo customerRepo;

    @Autowired
    CustomerConvertor convertor;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getId())){
            new RuntimeException(dto.getId()+" Customer Already Exists..!");
        }
        customerRepo.save(convertor.customerDtoToCustomerEntity(dto));
    }
}
