package lk.nexttravel.package_server.service;

import lk.nexttravel.package_server.dto.PackageDTO;

import java.util.List;

public interface PackageService {

    void savePackage(PackageDTO dto);
    void updatePackage(PackageDTO dto);
    void deletePackage(String id);
    PackageDTO findById(String id);
    List<PackageDTO> getAll();
}
