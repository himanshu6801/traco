package com.techstack.traco.web;

import org.springframework.web.bind.annotation.RestController;

import com.techstack.traco.model.Countries;
import com.techstack.traco.model.FullData;
import com.techstack.traco.service.TrackerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TracoController {

  @Autowired
  TrackerService trackerService;

  @GetMapping
  public String getIntro() {
    return "Traco Application : This application is meant to provide data visualization on C0vid-19 spread around the world!!";
  }

  @GetMapping("/covidCSVData/{type}")
  public List<Countries> getCSVData(@PathVariable String type) {
    return this.trackerService.getCsvData(type);
  }

  @GetMapping("/covidData/{id}")
  public Optional<FullData> getCovidDataById(@PathVariable int id) {
    return this.trackerService.getRecords(id);
  }

  @GetMapping("/covidDataByDate/{date}")
  public List<FullData> getCovidDataById(@PathVariable String date) {
    return this.trackerService.getRecords(date);
  }

  @GetMapping("/covidDataByLocation/{country}")
  public List<FullData> covidDataByLocation(@PathVariable String country) {
    return this.trackerService.covidDataByLocation(country);
  }
  
  @GetMapping("/covidDataByLocationOrderByDate/{location}")
  public FullData covidDataByLocationOrderByDate(@PathVariable String location) {
    return this.trackerService.covidDataByLocationOrderByDate(location);
  }
}
