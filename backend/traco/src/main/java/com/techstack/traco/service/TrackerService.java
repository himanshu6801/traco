package com.techstack.traco.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class TrackerService {
  
  
  public List<String[]> getCSVData() {
    
    
//    CSVParser parser = new CSVParserBuilder()
//        .withSeparator(',')
//        .withIgnoreQuotations(true)
//        .build();
    
    try {
      Reader reader = new FileReader("/Users/geniausr/Himanshu/Work/Learn Tech/java/traco/backend/traco/src/main/resources/new_deaths.csv");
      CSVReader csvReader = new CSVReaderBuilder(reader)
          .withSkipLines(0)
//          .withCSVParser(parser)
          .build();
      
      List<String[]> list = new ArrayList<>();
      list = csvReader.readAll();
      System.out.println("--------------list----");
      list.stream().forEach(System.out::println);
      reader.close();
      csvReader.close();
      return list;
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }
 
}
