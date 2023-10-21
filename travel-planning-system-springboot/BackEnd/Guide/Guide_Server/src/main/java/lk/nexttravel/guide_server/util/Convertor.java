package lk.nexttravel.guide_server.util;

import lk.nexttravel.guide_server.dto.GuideDTO;
import lk.nexttravel.guide_server.entity.Guide;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Convertor {

    @Autowired
    ModelMapper modelMapper;

    public Guide guideDtoToGuideEntity(GuideDTO guideDTO){
        return modelMapper.map(guideDTO,Guide.class);
    }

    public GuideDTO guideEntityToGuideDto(Guide guide){
        return modelMapper.map(guide, GuideDTO.class);
    }

    public List<GuideDTO> guideEntityListToGuideDTOList(List<Guide> guides){
        return modelMapper.map(guides,new TypeToken<List<GuideDTO>>(){}.getType());
    }
}
