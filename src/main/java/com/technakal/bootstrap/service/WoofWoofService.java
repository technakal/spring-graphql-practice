package com.technakal.bootstrap.service;

import com.technakal.bootstrap.entity.WoofWoof;

import java.util.List;

public interface WoofWoofService {
  List<WoofWoof> retrieveAllWoofWoofs();
  List<String> retrieveAllBreeds();
  List<String> retrieveAllNames();
  String retrieveBreedById(Long id);
}
