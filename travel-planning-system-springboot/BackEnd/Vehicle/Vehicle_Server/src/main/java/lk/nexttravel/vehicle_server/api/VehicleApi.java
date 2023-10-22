package lk.nexttravel.vehicle_server.api;

import lk.nexttravel.vehicle_server.dto.VehicleDTO;
import lk.nexttravel.vehicle_server.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleApi {

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<String> saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.saveVehicle(vehicleDTO);
        return new ResponseEntity<>(vehicleDTO.getId()+" Vehicle Saved..!", HttpStatus.OK);
    }
}
