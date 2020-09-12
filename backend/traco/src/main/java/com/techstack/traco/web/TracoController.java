package com.techstack.traco.web;

import org.springframework.web.bind.annotation.RestController;

import com.techstack.traco.service.TrackerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TracoController {
  
  @Autowired
  TrackerService trackerService;

  @GetMapping
  public String getIntro() {
    return "Traco Application : This application is meant to provide data visualization on C0vid-19 spread around the world!!";
    }
  
  @GetMapping("/csvData")
  public List<String[]> getCSVData() {
    return this.trackerService.getCSVData();
    
  }
}
