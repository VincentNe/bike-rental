package com.csharp.bikerental.persistence.model.Station;

public class LockCommand implements  Command{
    private Lock lock;

    public LockCommand(Lock lock ){
        this.lock    = lock;
    }
    public void execute(){
        lock.lock();
    }
}
