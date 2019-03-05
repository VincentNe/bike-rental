package com.csharp.bikerental.model;

import com.csharp.bikerental.persistence.model.Stand;
import com.csharp.bikerental.persistence.model.Station;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StationTest {







    @Test
    public void countStandsWithoutBikes(){
        Station station = new Station("TestStation");
        station.addStand(new Stand());
        assertEquals(1 ,station.getEmptyStands());


    }
    @Test
    public void countStandsWithBikes(){
        Station station = new Station("TestStation");
        station.addStand(new Stand());
        station.addStand(new Stand());
        station.addStand(new Stand());

        assertEquals(3,station.getEmptyStands());
    }

}
