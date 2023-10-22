package lk.nexttravel.vehicle_server.api;

import lk.nexttravel.vehicle_server.dto.VehicleDTO;
import lk.nexttravel.vehicle_server.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public ResponseEntity<String> updateVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity<>(vehicleDTO.getId()+" Vehicle Updated..!",HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteVehicle(String id){
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(id+" Vehicle Deleted..!",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<VehicleDTO> findVehicleById(String id){
        return new ResponseEntity<>(vehicleService.getVehicleById(id),HttpStatus.OK);
    }
}
