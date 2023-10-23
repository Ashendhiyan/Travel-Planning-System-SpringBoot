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
    private String brand;
    private String category;
    private String fuelType;
    private boolean hybridStatus;
    private double fuelUsage;
    private int seatCapacity;
    private String vehicleType;
    private String transmissionType;
    private String driverName;
    private String driverLicenseId;
    @Column(columnDefinition = "LONGTEXT")
    private String driverLicenseImage;
    @Column(columnDefinition = "LONGTEXT")
    private String frontView;
    @Column(columnDefinition = "LONGTEXT")
    private String backView;
    @Column(columnDefinition = "LONGTEXT")
    private String leftSideView;
    @Column(columnDefinition = "LONGTEXT")
    private String rightSideView;
}
