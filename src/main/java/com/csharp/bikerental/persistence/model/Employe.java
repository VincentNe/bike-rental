package com.csharp.bikerental.persistence.model;

import javax.persistence.Entity;

@Entity
public class Employe extends  User{


    public Employe() {

    }
    public Employe(String name,String username,String password){
        super(name, username,password);
    }

    @Override
    public boolean rentbike() {
        // TODO SAVE BIKE as Rented
        return true ;
    }
}
