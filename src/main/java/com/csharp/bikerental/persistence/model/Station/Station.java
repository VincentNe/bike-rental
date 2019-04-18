package com.csharp.bikerental.persistence.model.Station;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String stationName;
    // ,
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<Stand> stands;

    //region Getters and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<Stand> getStands() {
        return stands;
    }
    public void setStands(List<Stand> stands) {
        this.stands = stands;
    }
    //endregion

    public Station(){

    }
    public Station(String stationName){
        this.stationName  = stationName;
        stands = new ArrayList<>();
    }

    public void addStand(Stand stand){
        stands.add(stand);
    }

    public int getEmptyStands(){
        return (int) stands.stream().filter(Stand::isEmpty).count();
    }
    public int getTotalStands(){
        return stands.size();
    }

}
