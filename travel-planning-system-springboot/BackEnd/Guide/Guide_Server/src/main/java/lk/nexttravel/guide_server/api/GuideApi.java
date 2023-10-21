package lk.nexttravel.guide_server.api;

import lk.nexttravel.guide_server.dto.GuideDTO;
import lk.nexttravel.guide_server.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guide")
public class GuideApi {

    @Autowired
    GuideService guideService;

    @PostMapping
    public ResponseEntity<String> saveGuide(@RequestBody GuideDTO guideDTO){
        guideService.saveGuide(guideDTO);
        return new ResponseEntity<>(guideDTO.getId()+" Guide saved..!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateGuide(@RequestBody GuideDTO guideDTO){
        guideService.updateGuide(guideDTO);
        return new ResponseEntity<>(guideDTO.getId()+" Guide Updated..!",HttpStatus.OK);
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
