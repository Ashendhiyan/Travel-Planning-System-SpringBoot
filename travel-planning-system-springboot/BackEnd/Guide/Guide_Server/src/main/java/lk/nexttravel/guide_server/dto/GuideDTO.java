package lk.nexttravel.guide_server.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDTO {
    private String id;
    private String name;
    private String address;
    private int age;
    private String gender;
    private String number;
    private String images;
    private String guideNicImages;
    private String experience;
    private int manDayValue;
}
