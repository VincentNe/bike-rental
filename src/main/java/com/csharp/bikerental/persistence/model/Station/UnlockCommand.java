package com.csharp.bikerental.persistence.model.Station;

public class UnlockCommand implements  Command {

    private Lock lock;

    public UnlockCommand(Lock lock){
        this.lock = lock;
    }
    public void execute(){
        lock.unLock();
    }
}
