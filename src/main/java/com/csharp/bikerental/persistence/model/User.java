package com.csharp.bikerental.persistence.model;

import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.engine.internal.Cascade;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="UserTable")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;


    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @OneToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    protected List<Rental> twoWheel;

    //region Getters and Setters


    public List<Rental> getTwoWheel() {
        return twoWheel;
    }

    public void setTwoWheel(List<Rental> twoWheel) {
        this.twoWheel = twoWheel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //endregion

    public User(){
        twoWheel = new ArrayList<>();
    }
    public User(String name,String username, String password){
        twoWheel = new ArrayList<>();

        this.name = name;
        this.username  = username;
        //TODO ADD encryption to password
        this.password = new BCryptPasswordEncoder().encode(password);     }

    public abstract boolean rentbike(Stand s);
    public abstract boolean returnBike(String twoWheelId);

}
