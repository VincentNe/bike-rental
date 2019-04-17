package com.csharp.bikerental.persistence.model.Station;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean isLocked;

    //region Getters and Setters
    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//endregion

    public Lock(){
        isLocked = true;
    }

    public void lock(){
        System.out.println("lock Bike Stand");
        isLocked = true;
    }
    public void unLock(){
        System.out.println("Unlock Bike Stand");
        isLocked = false;
    }
}
