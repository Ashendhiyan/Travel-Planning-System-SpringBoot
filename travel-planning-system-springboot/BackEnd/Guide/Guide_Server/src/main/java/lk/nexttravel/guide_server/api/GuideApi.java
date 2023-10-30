package lk.nexttravel.guide_server.api;

import lk.nexttravel.guide_server.dto.GuideDTO;
import lk.nexttravel.guide_server.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/guide")
public class GuideApi {

    @Autowired
    GuideService guideService;


    @PostMapping
    public ResponseEntity<String> saveGuide(
            @RequestParam("guideId") String guideId,
            @RequestParam("guideName") String guideName,
            @RequestParam("address") String address,
            @RequestParam("gender") String gender,
            @RequestParam("number") String number,
            @RequestParam("experience") String experience,
            @RequestParam("manDayValue") double manDayValue,
            @RequestParam("guideImage")MultipartFile guideImage,
            @RequestParam("nicImage")MultipartFile nicImage
            ){
        try{
            guideService.saveGuide(new GuideDTO(
                    guideId,
                    guideName,
                    address,
                    gender,
                    number,
                    experience,
                    manDayValue,
                    Base64.getEncoder().encodeToString(guideImage.getBytes()),
                    Base64.getEncoder().encodeToString(nicImage.getBytes())
            ));
        } catch (IOException e) {
            throw new RuntimeException("Image Not Found..!");
        }
        return new ResponseEntity<>(guideId+" Guide Saved..!",HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<String> updateGuide(
            @RequestParam("guideId") String guideId,
            @RequestParam("guideName") String guideName,
            @RequestParam("address") String address,
            @RequestParam("gender") String gender,
            @RequestParam("number") String number,
            @RequestParam("experience") String experience,
            @RequestParam("manDayValue") double manDayValue,
            @RequestParam("guideImage")MultipartFile guideImage,
            @RequestParam("nicImage")MultipartFile nicImage
    ){
        try{
            guideService.updateGuide(new GuideDTO(
                    guideId,
                    guideName,
                    address,
                    gender,
                    number,
                    experience,
                    manDayValue,
                    Base64.getEncoder().encodeToString(guideImage.getBytes()),
                    Base64.getEncoder().encodeToString(nicImage.getBytes())
            ));
        } catch (IOException e) {
            throw new RuntimeException("Image Not Found..!");
        }
        return new ResponseEntity<>(guideId+" Guide Updated..!",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<GuideDTO> findById(String id){
        return new ResponseEntity<>(guideService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteGuide(String id){
        guideService.deleteGuide(id);
        return new ResponseEntity<>(id+" Guide Deleted..!",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GuideDTO>> getAllGuides(){
        return new ResponseEntity<>(guideService.findAll(),HttpStatus.OK);
    }
}
