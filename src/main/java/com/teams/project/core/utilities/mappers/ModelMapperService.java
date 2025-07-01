package com.teams.project.core.utilities.mappers;
import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperService {
        private final ModelMapper modelMapper;

        public ModelMapper getModelMapperForRequestDto() {
            this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);
            return this.modelMapper;
        }

        public ModelMapper getModelMapperForResponseDto() {
            this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
            return this.modelMapper;
    }


}




