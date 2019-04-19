package com.csharp.bikerental.service.UserService;

import com.csharp.bikerental.persistence.model.*;
import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Subscriptions.AnnualSubscription;
import com.csharp.bikerental.persistence.model.Subscriptions.PayAsYouGoSubscription;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.Employee;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.repo.StandRepository;
import com.csharp.bikerental.persistence.repo.TwoWheelRepository;
import com.csharp.bikerental.service.StationService.StationServiceImpl;
import org.springframework.security.core.userdetails.User.UserBuilder;
import com.csharp.bikerental.persistence.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService,UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StationServiceImpl stationService;

    @Autowired
    private StandRepository standRepository;
    @Autowired
    private TwoWheelRepository twoWheelRepository;


    public boolean rentBike(String username, Long standId){
        User u = userRepository.findByUsername(username);
        Stand stand = stationService.getStandById(standId);
        boolean result = u.rentbike(stand);
        standRepository.save(stand);
        userRepository.save(u);
        return  result;
    }
    public void saveUser(User u){
        userRepository.save(u);
    }
    public User getUser(Long id){
        return  userRepository.findById(id).get();
    }
    public User getUserByUsername(String username){
        return  userRepository.findByUsername(username);
    }
    public void removeUser(Long id){
         userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        //builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
        builder.password(user.getPassword());
        //TODO Replace with something more dynamic
        if (user instanceof Customer){
            builder.authorities("ROLE_USER");
        }
        else{
            builder.authorities("ROLE_ADMIN");
        }

        return builder.build();
    }


    public UserEdit editUser( String username) throws  UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        UserEdit userEdit = new UserEdit();
        UserEditSaver saver = userEdit.Saveto();
        UserEditCaretaker userFormCaretaker = new UserEditCaretaker();
        userFormCaretaker.addSaver(saver);
        userFormCaretaker.toString();
        saveUser(user);
        return userEdit;

    }

    public UserEdit undoEdit( String username) throws  UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        UserEdit userEdit = new UserEdit();
        UserEditCaretaker userFormCaretaker = new UserEditCaretaker();
        UserEditSaver savers=userFormCaretaker.getSaver();
        userEdit.undoSave(savers);
        userEdit.toString();
        return userEdit;

    }

    @Override
    public void returnBike(String username, Long standId, String bikeId) {
        User u = userRepository.findByUsername(username);
        if( u.returnBike(bikeId)){
            Stand stand = stationService.getStandById(standId);
            TwoWheel twoWheel = twoWheelRepository.findByIdentifier(bikeId);
            stand.putBikeInStand(twoWheel);
            standRepository.save(stand);
            userRepository.save(u);
        };

    }

}
