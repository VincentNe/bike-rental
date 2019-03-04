package com.csharp.bikerental.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Stand> stands;

    public Station(){
        stands = new ArrayList<>();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public void addStand(Stand stand){
        stands.add(stand);
    }

    public int getEmptyStands(){
        return (int) stands.stream().filter(Stand::isEmpty).count();
    }

}
