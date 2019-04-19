package com.csharp.bikerental.persistence.model;

import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;

import javax.persistence.*;

    @Entity
    public class Rental{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private long id;

        @OneToOne
        private TwoWheel t;
        @OneToOne
        private Subscription s;
        public Rental(){

        }
        public Rental(TwoWheel t, Subscription s){
            setT(t);
            setS(s);
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public TwoWheel getT() {
            return t;
        }

        public void setT(TwoWheel t) {
            this.t = t;
        }

        public Subscription getS() {
            return s;
        }

        public void setS(Subscription s) {
            this.s = s;
        }
    }

