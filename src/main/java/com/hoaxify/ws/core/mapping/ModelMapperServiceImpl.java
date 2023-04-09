package com.hoaxify.ws.core.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperServiceImpl implements ModelMapperService {

  @Autowired private ModelMapper modelMapper;

  @Override
  public ModelMapper getMapper() {
    this.modelMapper
        .getConfiguration()
        .setAmbiguityIgnored(true)
        .setMatchingStrategy(MatchingStrategies.STANDARD);
    return this.modelMapper;
  }
}
