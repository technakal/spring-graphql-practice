package com.technakal.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.technakal.bootstrap.entity.WoofWoof;
import com.technakal.bootstrap.exception.WoofWoofNotFoundException;
import com.technakal.bootstrap.repository.WoofWoofRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

  private WoofWoofRepository woofWoofRepository;

  public Query(WoofWoofRepository woofWoofRepository) {
    this.woofWoofRepository = woofWoofRepository;
  }

  public Iterable<WoofWoof> findAllWoofWoofs() {
    return woofWoofRepository.findAll();
  }

  public WoofWoof findWoofWoofById(Long id) {

    Optional<WoofWoof> optionalWoofWoof = woofWoofRepository.findById(id);
    if(optionalWoofWoof.isPresent()) {
      return optionalWoofWoof.get();
    } else {
      throw new WoofWoofNotFoundException("Woof Woof Not Found", id);
    }
  }

}
