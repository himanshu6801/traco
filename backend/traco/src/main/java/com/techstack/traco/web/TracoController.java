package com.techstack.traco.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TracoController {

  @GetMapping
  public String getIntro() {
    return "Traco Application : This application is meant to provide data visualization on C0vid-19 spread around the world!!"
;  }
}
