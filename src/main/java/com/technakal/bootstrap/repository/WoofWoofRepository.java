package com.technakal.bootstrap.repository;

import com.technakal.bootstrap.entity.WoofWoof;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WoofWoofRepository extends CrudRepository<WoofWoof, Long> {
  @Query("select A.id, A.breed from WoofWoof A where A.id = :id")
  String findBreedById(Long id);

  @Query("select distinct A.breed from WoofWoof A")
  List<String> findAllBreed();

  @Query("select A.name from WoofWoof A")
  List<String> findAllName();

}
