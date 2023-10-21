package lk.nexttravel.package_server.api;

import lk.nexttravel.package_server.dto.PackageDTO;
import lk.nexttravel.package_server.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/package")
public class PackageAPI {
    @Autowired
    PackageService packageService;

    @PostMapping
    public ResponseEntity<String> savePackage(@RequestBody PackageDTO  packageDTO){
        packageService.savePackage(packageDTO);
        return new ResponseEntity<>(packageDTO.getPackageId()+" Package Saved..!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updatePackage(@RequestBody PackageDTO dto){
        packageService.updatePackage(dto);
        return new ResponseEntity<>(dto.getPackageId()+"Package Updated..!",HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteCustomer(String id){
        packageService.deletePackage(id);
        return new ResponseEntity<>(id+"Package Deleted",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<PackageDTO> findPackageId(String id){
        PackageDTO packageDTO = packageService.findById(id);
        return new ResponseEntity<>(packageDTO,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PackageDTO>> getAllPackages(){
        List<PackageDTO> all = packageService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
}
