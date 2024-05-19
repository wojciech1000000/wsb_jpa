package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public interface PatientService {

    
    PatientTO findById(Long id);
    void deletePatient(Long id);
    void deletePatientVisits(Long id);
    List<VisitEntity> findAllVisitsByPatientId(Long patientId);
    
}
