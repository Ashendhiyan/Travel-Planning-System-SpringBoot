package lk.nexttravel.vehicle_server.service.impl;

import lk.nexttravel.vehicle_server.dto.VehicleDTO;
import lk.nexttravel.vehicle_server.repo.VehicleServiceRepo;
import lk.nexttravel.vehicle_server.service.VehicleService;
import lk.nexttravel.vehicle_server.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleServiceRepo vehicleServiceRepo;

    @Autowired
    Convertor convertor;

    @Override
    public void saveVehicle(VehicleDTO dto) {
        if (vehicleServiceRepo.existsById(dto.getId())){
            new RuntimeException(dto.getId()+" Vehicle Already Exists..!");
        }
        vehicleServiceRepo.save(convertor.vehicleDtoToVehicleEntity(dto));
    }

    @Override
    public void updateVehicle(VehicleDTO dto) {
        if (!vehicleServiceRepo.existsById(dto.getId())){
            new RuntimeException(dto.getId()+" Vehicle Not Found..!");
        }
        vehicleServiceRepo.save(convertor.vehicleDtoToVehicleEntity(dto));
    }

    @Override
    public void deleteVehicle(String id) {
        if (!vehicleServiceRepo.existsById(id)){
            new RuntimeException(id+" Vehicle Not Found..!");
        }
        vehicleServiceRepo.deleteById(id);
    }
}
