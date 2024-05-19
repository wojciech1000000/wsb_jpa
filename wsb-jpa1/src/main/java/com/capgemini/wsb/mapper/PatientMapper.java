package com.capgemini.wsb.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public final class PatientMapper {


    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setAge(patientEntity.getAge());
        return patientTO;
    }
    
    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if(patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientEntity.getId());
        patientEntity.setFirstName(patientEntity.getFirstName());
        patientEntity.setLastName(patientEntity.getLastName());
        patientEntity.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientEntity.setEmail(patientEntity.getEmail());
        patientEntity.setPatientNumber(patientEntity.getPatientNumber());
        patientEntity.setDateOfBirth(patientEntity.getDateOfBirth());
        patientEntity.setAge(patientEntity.getAge());

                // Mapowanie listy wizyt
        if (patientTO.getVisitsList() != null) {
            List<VisitEntity> visitEntities = patientTO.getVisitsList().stream()
                    .map(visitTO -> VisitMapper.mapToEntity(visitTO)) // Wywołanie metody mapToEntity z VisitMapper
                    .collect(Collectors.toList());
            patientEntity.setVisitsList(visitEntities);
        }
        return patientEntity;
    }
}
