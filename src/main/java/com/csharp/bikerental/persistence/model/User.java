package com.csharp.bikerental.persistence.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

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
    //region Getters and Setters

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

    public User(){}
    public User(String name,String username, String password){
        this.name = name;
        this.username  = username;
        //TODO ADD encryption to password
        this.password = new BCryptPasswordEncoder().encode(password);     }

    public abstract boolean rentbike();
}
