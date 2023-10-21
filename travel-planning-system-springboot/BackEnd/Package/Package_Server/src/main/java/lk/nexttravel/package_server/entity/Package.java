package lk.nexttravel.package_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Package {
    @Id
    private String packageId;
    private String packageCategory;
    private int nightCount;
    private String travelArea;
    private int totalHeadCount;
    private boolean petStatus;
    private double price;
}
