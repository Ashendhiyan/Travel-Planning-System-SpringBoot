package lk.nexttravel.vehicle_server.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private String registrationNumber;
    private String vehicleBrand;
    private String category;
    private String fuelType;
    private boolean isHybrid;
    private double fuelUsage;
    private String frontView;
    private String rearView;
    private String sideView;
    private String otherSideView;
    private int seatCapacity;
    private String vehicleType;
    private String transmission;
    private String driverName;
    private String driverNumber;
    private String licenseFront;
    private String licenseRear;
}
