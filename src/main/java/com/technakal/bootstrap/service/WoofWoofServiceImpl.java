package com.technakal.bootstrap.service;

import com.technakal.bootstrap.entity.WoofWoof;
import com.technakal.bootstrap.repository.WoofWoofRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class WoofWoofServiceImpl implements WoofWoofService {

  @Autowired
  WoofWoofRepository woofWoofRepository;

  @Override
  public List<WoofWoof> retrieveAllWoofWoofs() {
    return (List<WoofWoof>)woofWoofRepository.findAll();
  }

  @Override
  public List<String> retrieveAllBreeds() {
    return woofWoofRepository.findAllBreed();
  }

  @Override
  public List<String> retrieveAllNames() {
    return woofWoofRepository.findAllName();
  }

  @Override
  public String retrieveBreedById(Long id) {
    // handle invalid ID error
    Optional<String> optionalBreed = Optional.ofNullable(woofWoofRepository.findBreedById(id));
    return optionalBreed.orElseThrow(DogNotFoundException::new);
  }
}
