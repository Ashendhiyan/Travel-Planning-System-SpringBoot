package lk.nexttravel.vehicle_server.repo;

import lk.nexttravel.vehicle_server.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleServiceRepo extends JpaRepository<Vehicle,String> {
}
