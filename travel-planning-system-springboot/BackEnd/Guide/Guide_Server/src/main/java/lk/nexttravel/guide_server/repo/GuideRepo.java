package lk.nexttravel.guide_server.repo;

import lk.nexttravel.guide_server.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<Guide,String> {
}
