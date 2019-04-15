package com.csharp.bikerental.persistence.model.Station;

public class Lock {
    private boolean isLocked;

    //region Getters and Setters
    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
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
