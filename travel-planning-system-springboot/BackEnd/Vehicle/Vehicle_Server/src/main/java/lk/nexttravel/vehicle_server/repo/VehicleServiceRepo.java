package lk.nexttravel.vehicle_server.repo;

import lk.nexttravel.vehicle_server.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleServiceRepo extends JpaRepository<Vehicle,String> {

     List<Vehicle> findByVehicleType(String vehicleTpe);

    boolean existsByVehicleType(String vehicleType);

    List<Vehicle> existsByTransmissionTypeAndSeatCapacityAndFuelType(String transmissionType, int seatCapacity, String fuelType);
}
