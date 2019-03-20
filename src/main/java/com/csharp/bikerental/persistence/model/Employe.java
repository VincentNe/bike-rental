package com.csharp.bikerental.persistence.model;

import javax.persistence.Entity;

@Entity
public class Employe extends  User{



    @Override
    public boolean rentbike() {
        // TODO SAVE BIKE as Rented
        return true ;
    }
}
