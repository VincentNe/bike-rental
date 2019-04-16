package com.csharp.bikerental.persistence.model.Station;

public class StandLockController {
    Command command;

    public StandLockController(){

    }
    public void setCommand(Command command){
        this.command = command;
    }
    public void action(){
        command.execute();
    }
}
