package lk.nexttravel.package_server.repo;

import lk.nexttravel.package_server.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageREPO extends JpaRepository<Package,String> {
}
