package com.technakal.bootstrap.web;

import com.technakal.bootstrap.entity.WoofWoof;
import com.technakal.bootstrap.service.WoofWoofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WoofWoofController {
  private WoofWoofService woofWoofService;

  @Autowired
  public void setWoofWoofService(WoofWoofService service) {
    this.woofWoofService = service;
  }

  @GetMapping("/api/all")
  public ResponseEntity<List<WoofWoof>> getAllWoofWoofs() {
    List<WoofWoof> list = woofWoofService.retrieveAllWoofWoofs();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @GetMapping("/api/breed")
  public ResponseEntity<List<String>> getAllBreeds() {
    List<String> list = woofWoofService.retrieveAllBreeds();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @GetMapping("/api/name")
  public ResponseEntity<List<String>> getAllNames() {
    List<String> list = woofWoofService.retrieveAllNames();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @GetMapping("/api/{id}/breed")
  public ResponseEntity<String> getWoofWoofById(@PathVariable Long id) {
    String woofWoof = woofWoofService.retrieveBreedById(id);
    return new ResponseEntity<>(woofWoof, HttpStatus.OK);
  }
}
