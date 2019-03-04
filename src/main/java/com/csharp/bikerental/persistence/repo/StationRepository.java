package com.csharp.bikerental.persistence.repo;

import com.csharp.bikerental.persistence.model.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends CrudRepository<Station,Long> {

}
