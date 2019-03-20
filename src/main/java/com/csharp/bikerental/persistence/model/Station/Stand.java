package com.csharp.bikerental.persistence.model.Station;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    //region Gettters and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    //endregion

    public Stand(){
    }



    public boolean isEmpty() {
        //TODO check if bike is in stand;
        return  true;
    }
}
