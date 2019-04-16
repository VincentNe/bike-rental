package com.csharp.bikerental.Service;

import com.csharp.bikerental.BikeRentalApplication;
import com.csharp.bikerental.dto.*;
import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.repo.ReservationRepository;
import com.csharp.bikerental.persistence.repo.TwoWheelRepository;
import com.csharp.bikerental.persistence.repo.UserRepository;
import com.csharp.bikerental.service.ReservationService.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BikeRentalApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
public class ReservationServiceTest {

    private MockMvc mvc;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Autowired
    private WebApplicationContext context;

    @Autowired
    ReservationServiceImpl reservationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReservationRepository reservationRepository;


    @Autowired
    TwoWheelRepository twoWheelRepository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

//     @Test
//     public void createOneTimeReservation() {
//         Customer customer = new Customer();
//         customer.setName("customer");
//         userRepository.save(customer);

//         ReserveOneTimeDto reserveOneTimeDto = new ReserveOneTimeDto();
//         reserveOneTimeDto.setTwoWheelId(2L);

//         Date date = new Date();
//         reserveOneTimeDto.setStartDate(date);
//         Date endDate = new Date();
//         endDate.setTime(date.getTime() + 3600000);
//         reserveOneTimeDto.setEndDate(endDate);

//         OneTimeReservationDto oneTimeReservationDto = reservationService.createOneTimeReservation(customer, reserveOneTimeDto);

//         assertNotNull(oneTimeReservationDto);
//         assertEquals("customer", oneTimeReservationDto.getUserDto().getName());

//         TwoWheel twoWheel = twoWheelRepository.findById("1").orElse(null);

//         Date inbetween = new Date();
//         inbetween.setTime(inbetween.getTime() + 10000);
//         assertNotNull(reservationService.checkIfTwoWheelReserved(twoWheel, inbetween));

//         Date notInbetween = new Date();
//         notInbetween.setTime(notInbetween.getTime() + 7200000);
//         assertNull(reservationService.checkIfTwoWheelReserved(twoWheel, notInbetween));


//     }

//     @Test
//     public void shouldntCreateSecondReservation() {
//         Customer customer = new Customer();
//         customer.setName("customer");

//         userRepository.save(customer);

//         ReserveOneTimeDto reserveOneTimeDto1 = new ReserveOneTimeDto();
//         reserveOneTimeDto1.setTwoWheelId(1L);

//         Date date = new Date();
//         reserveOneTimeDto1.setStartDate(date);
//         Date endDate = new Date();
//         endDate.setTime(date.getTime() + 3600000);
//         reserveOneTimeDto1.setEndDate(endDate);

//         OneTimeReservationDto oneTimeReservationDto = reservationService.createOneTimeReservation(customer, reserveOneTimeDto1);

//         ReserveOneTimeDto reserveOneTimeDto2 = new ReserveOneTimeDto();
//         reserveOneTimeDto2.setTwoWheelId(1L);

//         date = new Date();
//         reserveOneTimeDto2.setStartDate(date);
//         endDate = new Date();
//         endDate.setTime(date.getTime() + 3600000);
//         reserveOneTimeDto2.setEndDate(endDate);

//     }
}
