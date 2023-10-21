package lk.nexttravel.guide_server.service;

import lk.nexttravel.guide_server.dto.GuideDTO;

import java.util.List;

public interface GuideService {
    void saveGuide(GuideDTO dto);
    void updateGuide(GuideDTO dto);
    GuideDTO findById(String id);
    void deleteGuide(String id);
    List<GuideDTO> findAll();
}
