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
public  interface ReservationServiceFacadeInterface{
	
    public OneTimeReservationDto createOneTimeReservation(Customer customer, ReserveOneTimeDto reserveOneTimeDto);
    public MaintenanceReservationDto createMaintenanceReservation(Employee employee, ReserveMaintenanceDto reserveMaintenanceDto);
    public RepeatingReservationDto createRepeatingReservation(User user, ReserveRepeatingDto reserveRepeatingDto);
    public Reservation checkIfTwoWheelReserved(TwoWheel twoWheel, Date date);


}
