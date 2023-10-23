package lk.nexttravel.guide_server.service.impl;

import lk.nexttravel.guide_server.dto.GuideDTO;
import lk.nexttravel.guide_server.entity.Guide;
import lk.nexttravel.guide_server.repo.GuideRepo;
import lk.nexttravel.guide_server.service.GuideService;
import lk.nexttravel.guide_server.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    GuideRepo guideRepo;

    @Autowired
    Convertor convertor;

    @Override
    public void saveGuide(GuideDTO dto) {
        if (guideRepo.existsById(dto.getId())){
            new RuntimeException(dto.getId()+" Guide Already Exists..!");
        }else {
            guideRepo.save(convertor.guideDtoToGuideEntity(dto));
        }
    }

    @Override
    public void updateGuide(GuideDTO dto) {
        if (!guideRepo.existsById(dto.getId())){
            new RuntimeException(dto.getId()+"Guide Not Found..!");
        }else {
            guideRepo.save(convertor.guideDtoToGuideEntity(dto));
        }
    }

    @Override
    public GuideDTO findById(String id) {
        if (!guideRepo.existsById(id)){
            new RuntimeException(id+" Guide Not Found");
        }
        return convertor.guideEntityToGuideDto(guideRepo.findById(id).get());
    }

    @Override
    public void deleteGuide(String id) {
        if (!guideRepo.existsById(id)){
            new RuntimeException(id+ " Guide Not Found..!");
        }else {
            guideRepo.deleteById(id);
        }
    }

    @Override
    public List<GuideDTO> findAll() {
        return convertor.guideEntityListToGuideDTOList( guideRepo.findAll());
    }
}
