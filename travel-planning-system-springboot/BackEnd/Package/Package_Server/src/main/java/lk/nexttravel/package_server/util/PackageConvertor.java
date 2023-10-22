package lk.nexttravel.package_server.util;

import lk.nexttravel.package_server.dto.PackageDTO;
import lk.nexttravel.package_server.entity.Package;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PackageConvertor {
    @Autowired
    ModelMapper modelMapper;

    public Package packageDtoToPackageEntity(PackageDTO dto) {
        return modelMapper.map(dto, Package.class);
    }

    public PackageDTO packageEntityToPackageDto(Package entity){
        return modelMapper.map(entity, PackageDTO.class);
    }

    public List<PackageDTO> packageEntityListToPackageDTOList(List<Package> packages){
        return modelMapper.map(packages,new TypeToken<List<PackageDTO>>(){}.getType());
    }
}
