package com.csharp.bikerental.service.ReservationService;

import com.csharp.bikerental.dto.*;
import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Employee;

import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.persistence.model.reservation.MaintenanceReservation;
import com.csharp.bikerental.persistence.model.reservation.OneTimeReservation;
import com.csharp.bikerental.persistence.model.reservation.RepeatingReservation;
import com.csharp.bikerental.persistence.model.reservation.Reservation;
import com.csharp.bikerental.persistence.repo.ReservationRepository;
import com.csharp.bikerental.persistence.repo.TwoWheelRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public  class ReservationServiceFacadeImpl implements ReservationServiceFacadeInterface{
    @Autowired
     ReservationRepository reservationRepository;

    @Autowired
    TwoWheelRepository twoWheelRepository;
    
    ReservationServiceInterface reservationService = new ReservationServiceImpl();


    public OneTimeReservationDto createOneTimeReservation(Customer customer, ReserveOneTimeDto reserveOneTimeDto) throws ServiceException {
        return reservationService.createOneTimeReservation(customer,reserveOneTimeDto);
    }

    public MaintenanceReservationDto createMaintenanceReservation(Employee employee, ReserveMaintenanceDto reserveMaintenanceDto) throws ServiceException {
        return reservationService.createMaintenanceReservation(employee,reserveMaintenanceDto);
    }

    public RepeatingReservationDto createRepeatingReservation(User user, ReserveRepeatingDto reserveRepeatingDto) throws ServiceException {
        return reservationService.createRepeatingReservation(user,reserveRepeatingDto);
    }

    public Reservation checkIfTwoWheelReserved(TwoWheel twoWheel, Date date){
        return reservationService.checkIfTwoWheelReserved(twoWheel,date);
    }


}
