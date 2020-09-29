package com.treknuts.glucoseapi.models;

import org.hibernate.type.LocalDateTimeType;

import javax.persistence.*;

@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entry_id")
    private Long entry_id;

    private int value;
    private int bolus;
    private int correction;
    private LocalDateTimeType created;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Entry() {}

    public Long getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(Long entry_id) {
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

    public LocalDateTimeType getCreated() {
        return created;
    }

    public void setCreated(LocalDateTimeType created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
