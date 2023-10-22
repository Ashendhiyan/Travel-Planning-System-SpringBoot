package lk.nexttravel.package_server.repo;

import lk.nexttravel.package_server.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingServiceRepo extends JpaRepository<Booking,String> {
}
