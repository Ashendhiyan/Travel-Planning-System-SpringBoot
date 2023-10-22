package lk.nexttravel.vehicle_server.service;

import lk.nexttravel.vehicle_server.dto.VehicleDTO;

public interface VehicleService {
    void saveVehicle(VehicleDTO  dto);
    void updateVehicle(VehicleDTO dto);
    void deleteVehicle(String id);
    VehicleDTO getVehicleById(String id);
}
