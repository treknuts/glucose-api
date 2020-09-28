package com.treknuts.glucoseapi.models;

import org.hibernate.type.TimestampType;

import javax.persistence.*;

@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entry_id")
    private Integer entry_id;

    private int value;
    private int bolus;
    private int correction;
    private TimestampType created;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Entry() {}

    public Integer getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(Integer entry_id) {
        this.entry_id = entry_id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBolus() {
        return bolus;
    }

    public void setBolus(int bolus) {
        this.bolus = bolus;
    }

    public int getCorrection() {
        return correction;
    }

    public void setCorrection(int correction) {
        this.correction = correction;
    }

    public TimestampType getCreated() {
        return created;
    }

    public void setCreated(TimestampType created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
