package com.techstack.traco.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.techstack.traco.dao.FullDataDao;
import com.techstack.traco.model.Countries;
import com.techstack.traco.model.FullData;

@Service
public class TrackerService {

  @Autowired
  ResourceLoader resourceLoader;

  @Autowired
  FullDataDao fullDataDao;

  public Optional<FullData> getRecords(int id) {
    return this.fullDataDao.findById(id);
  }

  public List<FullData> getRecords(String date) {
    try {
      return this.fullDataDao.findByDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }
  
  public FullData covidDataByLocationOrderByDate(String location) {

    return this.fullDataDao.findFirstByLocationOrderByDateDesc(location);
  }

  public List<FullData> covidDataByLocation(String location) {
    return this.fullDataDao.findByLocation(location);
  }

  // to fetch from CSV
  public List<Countries> getCsvData(String type) {

    String fileName = "/coronavirus-dataset/";
    switch (type) {
      case ("newDeaths"):
        fileName += "new_deaths.csv";
        break;
      case ("newCases"):
        fileName += "new_cases.csv";
        break;
      case ("totalCases"):
        fileName += "total_cases.csv";
        break;
      case ("totalDeaths"):
        fileName += "total_deaths.csv";
        break;
      default:
    }

    CSVParser parser = new CSVParserBuilder()
        .withSeparator(',')
        .withIgnoreQuotations(true)
        .build();

    try {
      // load csv file
      Resource resource = new ClassPathResource(fileName);
      Reader reader = new FileReader(resource.getFile());

      // read csv file
      CSVReader csvReader = new CSVReaderBuilder(reader)
          // .withSkipLines(1)
          // .withCSVParser(parser)
          .build();

      // List<String[]> list = new ArrayList<>();
      // list = csvReader.readAll();

      HeaderColumnNameMappingStrategy<Countries> beanStrategy = new HeaderColumnNameMappingStrategy<Countries>();
      beanStrategy.setType(Countries.class);

      CsvToBean<Countries> csvToBean = new CsvToBean<Countries>();
      csvToBean.setCsvReader(csvReader);
      csvToBean.setMappingStrategy(beanStrategy);
      List<Countries> countryWiseData = csvToBean.parse();

      System.out.println(countryWiseData);
      reader.close();
      csvReader.close();
      return countryWiseData;

    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

}
