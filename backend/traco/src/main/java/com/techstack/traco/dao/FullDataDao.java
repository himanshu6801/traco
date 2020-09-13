package com.techstack.traco.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techstack.traco.model.FullData;

@Repository
public interface FullDataDao extends JpaRepository<FullData, Integer> {

  public List<FullData> findByDate(Date date);

  public List<FullData> findByLocation(String location);
  
  public FullData findFirstByLocationOrderByDateDesc(String location);


}
