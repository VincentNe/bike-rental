package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.dto.*;
import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Employee;
import com.csharp.bikerental.persistence.model.TwoWheel;
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
public  class ReservationService{
    @Autowired
     ReservationRepository reservationRepository;

    @Autowired
    TwoWheelRepository twoWheelRepository;

    public OneTimeReservationDto createOneTimeReservation(Customer customer, ReserveOneTimeDto reserveOneTimeDto) throws ServiceException {
        TwoWheel twoWheel = twoWheelRepository.findById(reserveOneTimeDto.getTwoWheelId()).orElse(null);

        if(twoWheel == null) {
            throw new ServiceException("twoWheel not found");
        }

        if(this.checkIfMachineReserved(twoWheel, reserveOneTimeDto.getStartDate()) != null) {
            throw new ServiceException("twoWheel already reserved at this date");
        }

        OneTimeReservation oneTimeReservation = new OneTimeReservation(customer,reserveOneTimeDto.getStartDate(),reserveOneTimeDto.getEndDate(),twoWheel);

        return new OneTimeReservationDto(reservationRepository.save(oneTimeReservation));
    }

    public MaintenanceReservationDto createMaintenanceReservation(Employee employee, ReserveMaintenanceDto reserveMaintenanceDto) throws ServiceException {
        TwoWheel twoWheel = twoWheelRepository.findById(reserveMaintenanceDto.getTwoWheelId()).orElse(null);

        if(twoWheel == null) {
            throw new ServiceException("twoWheel not found");
        }

        if(this.checkIfMachineReserved(twoWheel, reserveMaintenanceDto.getStartDate()) != null) {
            throw new ServiceException("twoWheel already reserved at this date");
        }

        MaintenanceReservation maintenanceReservation = new MaintenanceReservation(employee, twoWheel, reserveMaintenanceDto.getStartDate(), reserveMaintenanceDto.getEndDate());

        return new MaintenanceReservationDto(reservationRepository.save(maintenanceReservation));
    }

    public RepeatingReservationDto createRepeatingReservation(User user, ReserveRepeatingDto reserveRepeatingDto) throws ServiceException {
        TwoWheel twoWheel = twoWheelRepository.findById(reserveRepeatingDto.getTwoWheelId()).orElse(null);

        if(twoWheel == null) {
            throw new ServiceException("twoWheel not found");
        }

        if(this.checkIfMachineReserved(twoWheel, reserveRepeatingDto.getStartDate()) != null) {
            throw new ServiceException("twoWheel already reserved at this date");
        }

        RepeatingReservation repeatingReservation = new RepeatingReservation(twoWheel, user, reserveRepeatingDto.getReservationPeriodicity(), reserveRepeatingDto.getStartDate(), reserveRepeatingDto.getEndDate());

        return new RepeatingReservationDto(reservationRepository.save(repeatingReservation));
    }

    public Reservation checkIfMachineReserved(TwoWheel twoWheel, Date date){
        List<Reservation> reservations = reservationRepository.findAllByTwoWheelAndCancelledFalse(twoWheel);

        for(Reservation reservation: reservations) {
            if(!date.before(reservation.getStartDate()) && !date.after(reservation.getEndDate())) {
                // A reservation already exists
                return reservation;
            }

            if(reservation instanceof RepeatingReservation) {
                Long increaseTimeAmount = 0L;
                switch(((RepeatingReservation) reservation).getReservationPeriodicity()) {
                    case DAILY:
                        increaseTimeAmount = 86400000L;
                        break;
                    case WEEKLY:
                        increaseTimeAmount = 604800000L;
                        break;
                    case MONTHLY:
                        increaseTimeAmount = 2419200000L;
                        break;

                }
                Date startDate = reservation.getStartDate();
                Date endDate = reservation.getEndDate();

                while (date.after(endDate)) {
                    if(!date.before(startDate) && !date.after(endDate)) {
                        // A reservation already exists
                        return reservation;
                    }
                    startDate.setTime(startDate.getTime() + increaseTimeAmount);
                    endDate.setTime(endDate.getTime() + increaseTimeAmount);
                }
            }
        }
        return null;
    }


}
