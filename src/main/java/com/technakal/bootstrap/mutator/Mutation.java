package com.technakal.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.technakal.bootstrap.entity.WoofWoof;
import com.technakal.bootstrap.exception.BreedNotFoundException;
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

  public Boolean deleteWoofWoofBreed(String breed) {
    Boolean deleted = false;
    Iterable<WoofWoof> allWoofWoofs = woofWoofRepository.findAll();

    for(WoofWoof w:allWoofWoofs) {
      if(w.getBreed().equals(breed)) {
        woofWoofRepository.delete(w);
        deleted = true;
      };
    }

    if(!deleted) {
      throw new BreedNotFoundException("Breed not found", breed);
    }

    return deleted;
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
