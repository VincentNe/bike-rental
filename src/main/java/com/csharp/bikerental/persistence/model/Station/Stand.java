package com.csharp.bikerental.persistence.model.Station;

import com.csharp.bikerental.persistence.model.TwoWheel.Bike;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;

import javax.persistence.*;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    private StandLockController standLockController;

    @OneToOne(cascade = {CascadeType.ALL})
    private Lock lock  ;

    @OneToOne
    private TwoWheel bike;
    //region Gettters and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public StandLockController getStandLockController() {
        return standLockController;
    }

    public void setStandLockController(StandLockController standLockController) {
        this.standLockController = standLockController;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public TwoWheel getBike() {
        return bike;
    }

    public void setBike(TwoWheel bike) {
        this.bike = bike;
    }

    //endregion

    public Stand(){
        standLockController = new StandLockController();
        lock = new Lock();
    }



    public boolean isEmpty() {
        //TODO check if bike is in stand;
        return  true;
    }

    public void openStand() {
        standLockController.setCommand(new UnlockCommand(this.lock));
        standLockController.action();

    }
    public void closeStand(){
        standLockController.setCommand(new LockCommand(this.lock));
        standLockController.action();
    }
    public TwoWheel takeoutBike(){
        if(bike == null) return null;
        openStand();
        if(!lock.isLocked()) {
            TwoWheel result = bike;
            bike = null;
            return result;
        }
        return  null;
    }
    public void putBikeInStand(TwoWheel bike){
        if(bike != null) return;
        openStand();
        if(!lock.isLocked()){
            this.bike = bike;
        }
        closeStand();
    }
}
