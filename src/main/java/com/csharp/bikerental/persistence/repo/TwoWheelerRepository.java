package com.csharp.bikerental.persistence.repo;

import com.csharp.bikerental.persistence.model.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwoWheelerRepository extends CrudRepository<Bike,Long> {
}
