package com.capgemini.wsb.dto;

import java.time.LocalDateTime;
import java.io.Serializable;


public class VisitTO implements Serializable {

    private long id;

    private String description;

    private LocalDateTime time;

    private ShortDoctorTO doctor;

    private ShortPatientTO patient;//imie pacjenta nazwisko pacjenta ShortDoctorTO, ShortParintTO

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public ShortDoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(ShortDoctorTO doctor) {
        this.doctor = doctor;
    }

    public ShortPatientTO getPatient() {
        return patient;
    }

    public void setPatient(ShortPatientTO patient) {
        this.patient = patient;
    }
}
