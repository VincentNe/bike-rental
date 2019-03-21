package com.csharp.bikerental.persistence.repo;

import com.csharp.bikerental.persistence.model.TwoWheel;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TwoWheelRepository extends CrudRepository<TwoWheel, Long> {


}
