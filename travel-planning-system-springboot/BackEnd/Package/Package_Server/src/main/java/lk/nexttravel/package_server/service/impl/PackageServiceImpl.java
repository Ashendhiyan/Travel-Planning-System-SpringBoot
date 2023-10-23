package lk.nexttravel.package_server.service.impl;

import lk.nexttravel.package_server.dto.PackageDTO;
import lk.nexttravel.package_server.entity.Package;
import lk.nexttravel.package_server.repo.PackageREPO;
import lk.nexttravel.package_server.service.PackageService;
import lk.nexttravel.package_server.util.PackageConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PackageServiceImpl implements PackageService {
    @Autowired
    PackageREPO packageREPO;

    @Autowired
    PackageConvertor packageConvertor;
    @Override
    public void savePackage(PackageDTO dto) {
            if (packageREPO.existsById(dto.getPackageId())){
                throw new RuntimeException(dto.getPackageId()+"Package  id is already exists..!!");
            }else {
                packageREPO.save(packageConvertor.packageDtoToPackageEntity(dto));
            }
    }

    @Override
    public void updatePackage(PackageDTO dto) {
        if (!packageREPO.existsById(dto.getPackageId())){
            throw new RuntimeException(dto.getPackageId()+"Package is not in the system");
        }else {
            packageREPO.save(packageConvertor.packageDtoToPackageEntity(dto));
        }
    }

    @Override
    public void deletePackage(String id) {
        if (!packageREPO.existsById(id)){
            throw new RuntimeException(id+"Package Not Found..!");
        }
        packageREPO.deleteById(id);
    }

    @Override
    public PackageDTO findById(String id) {
        if (!packageREPO.existsById(id)){
            throw new RuntimeException(id+"Package Not Found..!");
        }
        Package aPackage = packageREPO.findById(id).get();
        return packageConvertor.packageEntityToPackageDto(aPackage);
    }

    @Override
    public List<PackageDTO> getAll() {
        return packageConvertor.packageEntityListToPackageDTOList(packageREPO.findAll());
    }
}

