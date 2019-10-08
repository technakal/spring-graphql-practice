package com.technakal.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.technakal.bootstrap.entity.WoofWoof;
import com.technakal.bootstrap.exception.WoofWoofNotFoundException;
import com.technakal.bootstrap.repository.WoofWoofRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

  private WoofWoofRepository woofWoofRepository;

  public Mutation(WoofWoofRepository woofWoofRepository) {
    this.woofWoofRepository = woofWoofRepository;
  }

  public WoofWoof createNewWoofWoof(String name, String breed) {
    WoofWoof woofWoof = new WoofWoof(name, breed);
    woofWoofRepository.save(woofWoof);
    return woofWoof;
  }

  public Boolean deleteWoofWoofById(Long id) {
    woofWoofRepository.deleteById(id);
    return true;
  }

  public WoofWoof updateWoofWoofName(String newName, Long id) {
    Optional<WoofWoof> optionalWoofWoof = woofWoofRepository.findById(id);

    if(optionalWoofWoof.isPresent()) {
      WoofWoof woofWoof = optionalWoofWoof.get();
      woofWoof.setName(newName);
      woofWoofRepository.save(woofWoof);
      return woofWoof;
    } else {
      throw new WoofWoofNotFoundException("Woof Woof Not Found.", id);
    }
  }
}
