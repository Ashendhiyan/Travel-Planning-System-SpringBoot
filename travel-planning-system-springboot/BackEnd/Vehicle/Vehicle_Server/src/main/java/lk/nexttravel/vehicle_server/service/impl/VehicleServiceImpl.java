package lk.nexttravel.vehicle_server.service.impl;

import lk.nexttravel.vehicle_server.dto.VehicleDTO;
import lk.nexttravel.vehicle_server.entity.Vehicle;
import lk.nexttravel.vehicle_server.repo.VehicleServiceRepo;
import lk.nexttravel.vehicle_server.service.VehicleService;
import lk.nexttravel.vehicle_server.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleServiceRepo vehicleServiceRepo;

    @Autowired
    Convertor convertor;

    @Override
    public void saveVehicle(VehicleDTO dto) {
        if (vehicleServiceRepo.existsById(dto.getRegistrationNumber())){
            throw new RuntimeException(dto.getRegistrationNumber()+" Vehicle Already Exists..!");
        }else {
            vehicleServiceRepo.save(convertor.vehicleDtoToVehicleEntity(dto));
        }
    }

    @Override
    public void updateVehicle(VehicleDTO dto) {
        if (!vehicleServiceRepo.existsById(dto.getRegistrationNumber())){
            throw new RuntimeException(dto.getRegistrationNumber()+" Vehicle Not Found..!");
        }else {
            vehicleServiceRepo.save(convertor.vehicleDtoToVehicleEntity(dto));
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (!vehicleServiceRepo.existsById(id)){
            throw new RuntimeException(id+" Vehicle Not Found..!");
        }
        vehicleServiceRepo.deleteById(id);
    }

    @Override
    public VehicleDTO getVehicleById(String id) {
        if (!vehicleServiceRepo.existsById(id)){
            throw new RuntimeException(id+" Vehicle Not Found..!");
        }
        return convertor.vehicleEntityToVehicleDto(vehicleServiceRepo.findById(id).get());
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return convertor.vehicleEntityListToVehicleDTOList(vehicleServiceRepo.findAll());
    }

    @Override
    public List<VehicleDTO> getAllVehiclesByVehicleType(String vehicleType) {
        if (!vehicleServiceRepo.existsByVehicleType(vehicleType)){
            throw new RuntimeException(vehicleType+" type vehicles cannot find in this server..!!");
        }
        return convertor.vehicleEntityListToVehicleDTOList( vehicleServiceRepo.findByVehicleType(vehicleType));
    }
}
