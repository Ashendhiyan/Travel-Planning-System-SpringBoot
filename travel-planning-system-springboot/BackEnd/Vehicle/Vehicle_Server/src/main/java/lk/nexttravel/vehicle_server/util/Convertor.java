package lk.nexttravel.vehicle_server.util;

import lk.nexttravel.vehicle_server.dto.VehicleDTO;
import lk.nexttravel.vehicle_server.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Convertor {

    @Autowired
    ModelMapper modelMapper;

    public Vehicle vehicleDtoToVehicleEntity(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO,Vehicle.class);
    }

    public VehicleDTO vehicleEntityToVehicleDto(Vehicle vehicle){
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    public List<VehicleDTO> vehicleEntityListToVehicleDTOList(List<Vehicle> vehicles){
        return modelMapper.map(vehicles,new TypeToken<List<VehicleDTO>>(){}.getType());
    }
}
