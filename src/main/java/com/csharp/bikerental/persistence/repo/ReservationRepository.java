package com.csharp.bikerental.persistence.repo;

import com.csharp.bikerental.persistence.model.TwoWheel;
import com.csharp.bikerental.persistence.model.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAllByTwoWheel(TwoWheel twoWheel);
    List<Reservation> findAllByTwoWheelAndCancelledFalse(TwoWheel twoWheel);

}
