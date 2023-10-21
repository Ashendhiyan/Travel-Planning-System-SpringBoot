package lk.nexttravel.hotel_server.repo;

import lk.nexttravel.hotel_server.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}
