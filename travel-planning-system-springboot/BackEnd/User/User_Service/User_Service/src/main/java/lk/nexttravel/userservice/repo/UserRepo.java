package lk.nexttravel.userservice.repo;

import lk.nexttravel.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
