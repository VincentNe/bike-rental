package com.csharp.bikerental.persistence.model.Station;

import javax.persistence.*;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private StandLockController standLockController;

    @OneToOne
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
        standLockController.action();

    }
    public void closeStand(){
        standLockController.setCommand(new LockCommand(this.lock));
        standLockController.action();
    }
}
