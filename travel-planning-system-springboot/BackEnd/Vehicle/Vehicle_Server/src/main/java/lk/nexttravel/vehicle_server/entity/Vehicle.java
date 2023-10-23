package lk.nexttravel.vehicle_server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vehicle {
    @Id
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
