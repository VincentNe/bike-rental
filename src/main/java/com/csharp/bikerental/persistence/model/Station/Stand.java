package com.csharp.bikerental.persistence.model.Station;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private StandLockController standLockController;
    private Lock lock  ;

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

    }
    public void closeStand(){
        standLockController.setCommand(new LockCommand(this.lock));
    }
}
