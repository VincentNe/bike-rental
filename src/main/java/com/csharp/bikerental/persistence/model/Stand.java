package com.csharp.bikerental.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Stand(){

    }

    public boolean isEmpty() {
        //TODO check if bike is in stand;
        return  true;
    }
}
