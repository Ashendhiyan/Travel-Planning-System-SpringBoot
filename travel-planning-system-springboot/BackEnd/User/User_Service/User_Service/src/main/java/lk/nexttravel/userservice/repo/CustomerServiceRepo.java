package lk.nexttravel.userservice.repo;

import lk.nexttravel.userservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerServiceRepo extends JpaRepository<Customer,String> {
}
