package com.techstack.traco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name = "full_data")
public class FullData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "location", nullable = true)
  private String location;

  @Column(name = "date", nullable = true)
  private Date date;

  @Column(name = "new_cases", nullable = true)
  private Integer newCases;

  @Column(name = "new_deaths", nullable = true)
  private Integer newDeaths;

  @Column(name = "total_cases", nullable = true)
  private Integer totalCases;

  @Column(name = "total_deaths", nullable = true)
  private Integer totalDeaths;

  @Column(name = "weekly_cases", nullable = true)
  private Integer weeklyCases;

  @Column(name = "weekly_deaths", nullable = true)
  private Integer weeklyDeaths;

  @Column(name = "biweekly_cases", nullable = true)
  private Integer biweeklyCases;

  @Column(name = "biweekly_deaths", nullable = true)
  private Integer biweeklyDeaths;
}
