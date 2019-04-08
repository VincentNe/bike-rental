package com.csharp.bikerental.persistence.repo;

import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TwoWheelRepository extends CrudRepository<TwoWheel, String> {


}
