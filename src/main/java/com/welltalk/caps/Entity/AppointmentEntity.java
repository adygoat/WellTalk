package com.welltalk.caps.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int makeappointmentid;

    private String Date;
    private String Time;
    private String message;

    @ManyToOne
    @JoinColumn(name = "userid", nullable=false)
    private UserEntity user;

    private Boolean decision;

    public AppointmentEntity() {
    }

    public AppointmentEntity(int makeappointmentid, String date, String time, String message, Boolean decision) {
        this.makeappointmentid = makeappointmentid;
        Date = date;
        Time = time;
        this.message = message;
        this.decision = decision;
    }

    public int getMakeAppointmentid() {
        return makeappointmentid;
    }

    public void setMakeAppointmentid(int makeappointmentid) {
        this.makeappointmentid = makeappointmentid;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }
}
