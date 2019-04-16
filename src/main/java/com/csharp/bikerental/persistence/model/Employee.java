package com.csharp.bikerental.persistence.model;

import javax.persistence.*;

@Entity
public class Employee extends  User{

    public Employee() {

    }
    public Employee( String name,String username,String password){
        super(name, username,password);

    }

    @Override
    public boolean rentbike() {
        // TODO SAVE BIKE as Rented
        return true ;
    }
}
