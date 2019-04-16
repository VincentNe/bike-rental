package com.csharp.bikerental.persistence.model.Station;

import javax.persistence.*;

@Entity
public class StandLockController {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //region Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Command getCommand() {
        return command;
    }
    //endregion
    @Transient
    private Command command;

    public StandLockController(){

    }
    public void setCommand(Command command){
        this.command = command;
    }
    public void action(){
        command.execute();
    }
}
