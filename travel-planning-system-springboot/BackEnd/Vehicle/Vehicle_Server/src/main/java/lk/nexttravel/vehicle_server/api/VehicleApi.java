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
            @RequestParam("vehicleBrand") String vehicleBrand,
            @RequestParam("category") String category,
            @RequestParam("fuelType") String fuelType,
            @RequestParam("isHybrid") boolean isHybrid,
            @RequestParam("fuelUsage") double fuelUsage,
            @RequestParam("frontView") MultipartFile frontView,
            @RequestParam("rearView") MultipartFile rearView,
            @RequestParam("sideView") MultipartFile sideView,
            @RequestParam("otherSideView") MultipartFile otherSideView,
            @RequestParam("seatCapacity") int seatCapacity,
            @RequestParam("vehicleType") String vehicleType,
            @RequestParam("transmission") String transmission,
            @RequestParam("driverName") String driverName,
            @RequestParam("driverNumber") String driverNumber,
            @RequestParam("driverLicense") MultipartFile driverLicense

    ) {
        try {
            vehicleService.saveVehicle(new VehicleDTO(
                    registrationNumber,
                    vehicleBrand,
                    category,
                    fuelType,
                    isHybrid,
                    fuelUsage,
                    Base64.getEncoder().encodeToString(frontView.getBytes()),
                    Base64.getEncoder().encodeToString(rearView.getBytes()),
                    Base64.getEncoder().encodeToString(sideView.getBytes()),
                    Base64.getEncoder().encodeToString(otherSideView.getBytes()),
                    seatCapacity,
                    vehicleType,
                    transmission,
                    driverName,
                    driverNumber,
                    Base64.getEncoder().encodeToString(driverLicense.getBytes())

            ));
        } catch (IOException e) {
            throw new RuntimeException("Image Not Found..!");
        }
        return new ResponseEntity<>(registrationNumber+" Vehicle Saved..!", HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<String> updateVehicle(
            @RequestParam("registrationNumber") String registrationNumber,
            @RequestParam("vehicleBrand") String vehicleBrand,
            @RequestParam("category") String category,
            @RequestParam("fuelType") String fuelType,
            @RequestParam("isHybrid") boolean isHybrid,
            @RequestParam("fuelUsage") double fuelUsage,
            @RequestParam("frontView") MultipartFile frontView,
            @RequestParam("rearView") MultipartFile rearView,
            @RequestParam("sideView") MultipartFile sideView,
            @RequestParam("otherSideView") MultipartFile otherSideView,
            @RequestParam("seatCapacity") int seatCapacity,
            @RequestParam("vehicleType") String vehicleType,
            @RequestParam("transmission") String transmission,
            @RequestParam("driverName") String driverName,
            @RequestParam("driverNumber") String driverNumber,
            @RequestParam("driverLicense") MultipartFile driverLicense
    ){
        try {
            vehicleService.updateVehicle(new VehicleDTO(
                    registrationNumber,
                    vehicleBrand,
                    category,
                    fuelType,
                    isHybrid,
                    fuelUsage,
                    Base64.getEncoder().encodeToString(frontView.getBytes()),
                    Base64.getEncoder().encodeToString(rearView.getBytes()),
                    Base64.getEncoder().encodeToString(sideView.getBytes()),
                    Base64.getEncoder().encodeToString(otherSideView.getBytes()),
                    seatCapacity,
                    vehicleType,
                    transmission,
                    driverName,
                    driverNumber,
                    Base64.getEncoder().encodeToString(driverLicense.getBytes())
            ));
        } catch (IOException e) {
            throw new RuntimeException("Image not Found..!!");
        }
        return new ResponseEntity<>(registrationNumber+" Vehicle has been Updated Successfully",HttpStatus.OK);
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
