package com.csharp.bikerental.persistence.repo;

import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandRepository extends CrudRepository<Stand, Long> {
}
