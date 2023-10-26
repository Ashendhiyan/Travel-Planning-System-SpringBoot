package lk.nexttravel.vehicle_server.api;

import lk.nexttravel.vehicle_server.dto.VehicleDTO;
import lk.nexttravel.vehicle_server.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleApi {

    @Autowired
    VehicleService vehicleService;


    @PostMapping
    public ResponseEntity<String> saveVehicle(
            @RequestParam("registrationNumber") String registrationNumber,
            @RequestParam("brand") String brand,
            @RequestParam("category") String category,
            @RequestParam("fuelType") String fuelType,
            @RequestParam("hybridStatus") boolean hybridStatus,
            @RequestParam("fuelUsage") double fuelUsage,
            @RequestParam("seatCapacity") int seatCapacity,
            @RequestParam("vehicleType") String vehicleType,
            @RequestParam("transmissionType") String transmissionType,
            @RequestParam("driverName") String driverName,
            @RequestParam("driverLicenseId") String driverLicenseId,
            @RequestParam("driverLicenseImage") MultipartFile driverLicenseImage,
            @RequestParam("frontView") MultipartFile frontView,
            @RequestParam("backView") MultipartFile backView,
            @RequestParam("leftSideView") MultipartFile leftSideView,
            @RequestParam("rightSideView") MultipartFile rightSideView
    ) {
        try {
            vehicleService.saveVehicle(new VehicleDTO(
registrationNumber,
                    brand,
                    category,
                    fuelType,
                    hybridStatus,
                    fuelUsage,
                    seatCapacity,
                    vehicleType,
                    transmissionType,
                    driverName,
                    driverLicenseId,
                    Base64.getEncoder().encodeToString(driverLicenseImage.getBytes()),
                    Base64.getEncoder().encodeToString(frontView.getBytes()),
                    Base64.getEncoder().encodeToString(backView.getBytes()),
                    Base64.getEncoder().encodeToString(leftSideView.getBytes()),
                    Base64.getEncoder().encodeToString(rightSideView.getBytes())
            ));
        } catch (IOException e) {
            throw new RuntimeException("Image Not Found..!");
        }
        return new ResponseEntity<>(registrationNumber+" Vehicle Saved..!", HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<String> updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity<>(vehicleDTO.getRegistrationNumber() + " Vehicle Updated..!", HttpStatus.OK);
    }

    @DeleteMapping(params = "registrationNumber")
    public ResponseEntity<String> deleteVehicle(String registrationNumber) {
        vehicleService.deleteVehicle(registrationNumber);
        return new ResponseEntity<>(registrationNumber + " Vehicle Deleted..!", HttpStatus.OK);
    }

    @GetMapping(params = "registrationNumber")
    public ResponseEntity<VehicleDTO> findVehicleById(String registrationNumber) {
        return new ResponseEntity<>(vehicleService.getVehicleById(registrationNumber), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping(params = "vehicleType", path = "/getAllVehiclesByVehicleType")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesByVehicleType(String vehicleType) {
        return new ResponseEntity<>(vehicleService.getAllVehiclesByVehicleType(vehicleType), HttpStatus.OK);
    }

    @GetMapping(params = {"transmissionType", "seatCapacity", "fuelType"}, path = "/getAllVehicleByTransmissionTypeAndSeatCapacityAndAndFuelType")
    public ResponseEntity<List<VehicleDTO>> getAllVehicleByTransmissionTypeAndSeatCapacityAndAndFuelType(
            String transmissionType, int seatCapacity, String fuelType
    ) {
        List<VehicleDTO> all = vehicleService.getAllVehicleByTransmissionTypeAndSeatCapacityAndAndFuelType(transmissionType, seatCapacity, fuelType);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
